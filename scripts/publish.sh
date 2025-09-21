#!/bin/bash

# publish.sh - Publish proto contracts to package repositories
# Usage: ./scripts/publish.sh [--go-only|--kotlin-only]

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"

cd "${PROJECT_ROOT}"

# Parse command line arguments
PUBLISH_GO=true
PUBLISH_KOTLIN=true

while [[ $# -gt 0 ]]; do
    case $1 in
        --go-only)
            PUBLISH_KOTLIN=false
            shift
            ;;
        --kotlin-only)
            PUBLISH_GO=false
            shift
            ;;
        *)
            echo "Unknown option: $1"
            echo "Usage: $0 [--go-only|--kotlin-only]"
            exit 1
            ;;
    esac
done

echo "🚀 Publishing proto contracts..."

# Verify we're on main branch for publishing
CURRENT_BRANCH=$(git rev-parse --abbrev-ref HEAD)
if [ "$CURRENT_BRANCH" != "main" ]; then
    echo "⚠️  Warning: Publishing from branch '$CURRENT_BRANCH' (not main)"
    read -p "Continue? (y/N): " -n 1 -r
    echo
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        exit 1
    fi
fi

# Check for uncommitted changes
if [ -n "$(git status --porcelain)" ]; then
    echo "❌ There are uncommitted changes. Please commit them first."
    git status --short
    exit 1
fi

# Get version from git tag or use default
VERSION=$(git describe --tags --exact-match 2>/dev/null || echo "v1.0.0-dev")
echo "📦 Publishing version: $VERSION"

# Generate code first
echo "⚙️  Generating code for publishing..."
if [ "$PUBLISH_GO" = true ]; then
    ./scripts/generate-go.sh
fi

if [ "$PUBLISH_KOTLIN" = true ]; then
    ./scripts/generate-kotlin.sh
fi

# Publish Go module (automatic via git tags)
if [ "$PUBLISH_GO" = true ]; then
    echo "📤 Publishing Go module..."

    # For Go modules, publishing is automatic when we push tags to GitHub
    # But we can validate that the module is accessible

    # Update go.mod version if needed
    go mod tidy

    # Test that the module builds
    go build ./gen/go/...

    echo "✅ Go module ready for publishing"
    echo "   To publish: git tag $VERSION && git push origin $VERSION"
    echo "   Then users can: go get github.com/traffic-tacos/proto-contracts@$VERSION"
fi

# Publish Kotlin/Java artifact
if [ "$PUBLISH_KOTLIN" = true ]; then
    echo "📤 Publishing Kotlin/Java artifact..."

    # Check if we have gradle wrapper or gradle
    if [ -f "./gradlew" ]; then
        GRADLE_CMD="./gradlew"
    elif command -v gradle &> /dev/null; then
        GRADLE_CMD="gradle"
    else
        echo "❌ Gradle is not available for Kotlin publishing"
        exit 1
    fi

    # Update version in build.gradle.kts if needed
    if [[ "$VERSION" =~ ^v(.+)$ ]]; then
        CLEAN_VERSION="${BASH_REMATCH[1]}"
        sed -i.bak "s/version = \".*\"/version = \"$CLEAN_VERSION\"/" build.gradle.kts
        rm -f build.gradle.kts.bak
    fi

    # Build and test
    $GRADLE_CMD clean build test

    # Publish to local repository for testing
    echo "📦 Publishing to local Maven repository..."
    $GRADLE_CMD publishToMavenLocal

    # For production, you would publish to a remote repository:
    # $GRADLE_CMD publish

    echo "✅ Kotlin/Java artifact published to local Maven repository"
    echo "   To publish to remote: configure publishing repository in build.gradle.kts"
    echo "   Then run: $GRADLE_CMD publish"
fi

# Create GitHub release notes
echo "📝 Creating release notes..."
cat > RELEASE_NOTES.md << EOF
# Release $VERSION

## Changes

$(git log --oneline $(git describe --tags --abbrev=0 HEAD~1)..HEAD 2>/dev/null || echo "- Initial release")

## Usage

### Go
\`\`\`bash
go get github.com/traffic-tacos/proto-contracts@$VERSION
\`\`\`

### Kotlin/Java
\`\`\`kotlin
dependencies {
    implementation("com.traffic-tacos:proto-contracts:${VERSION#v}")
}
\`\`\`

## Generated Artifacts

- Go packages: \`gen/go/\`
- Java/Kotlin packages: \`gen/java/\`

## Services Included

- Reservation Service (reservation.v1)
- Inventory Service (reservation.v1)
- Payment Service (payment.v1)
- Common Types (common.v1)
EOF

echo "✅ Proto contracts publishing preparation complete!"
echo ""
echo "📋 Next steps:"
echo "1. Review generated code and tests"
echo "2. Commit any version changes: git add -A && git commit -m 'Prepare release $VERSION'"
echo "3. Tag release: git tag $VERSION"
echo "4. Push to GitHub: git push origin main --tags"
echo "5. Create GitHub release with RELEASE_NOTES.md content"
echo ""
echo "📊 Package sizes:"
if [ "$PUBLISH_GO" = true ]; then
    echo "   Go: $(find gen/go -name "*.go" | wc -l | tr -d ' ') files"
fi
if [ "$PUBLISH_KOTLIN" = true ]; then
    echo "   Kotlin/Java: $(find gen/java -name "*.java" -o -name "*.kt" | wc -l | tr -d ' ') files"
    if [ -f "build/libs/proto-contracts-${VERSION#v}.jar" ]; then
        echo "   JAR size: $(du -h build/libs/proto-contracts-${VERSION#v}.jar | cut -f1)"
    fi
fi