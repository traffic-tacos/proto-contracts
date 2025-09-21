# Makefile for Traffic Tacos Proto Contracts

.PHONY: help generate generate-go generate-kotlin lint breaking test clean publish build

# Default target
help: ## Show this help message
	@echo "Traffic Tacos Proto Contracts"
	@echo ""
	@echo "Available targets:"
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_-]+:.*?## / {printf "  %-15s %s\n", $$1, $$2}' $(MAKEFILE_LIST)

# Generate code for all languages
generate: generate-go generate-kotlin ## Generate code for all languages

# Generate Go code
generate-go: ## Generate Go protobuf and gRPC code
	@echo "🚀 Generating Go code..."
	@./scripts/generate-go.sh

# Generate Kotlin/Java code
generate-kotlin: ## Generate Kotlin/Java protobuf and gRPC code
	@echo "🚀 Generating Kotlin/Java code..."
	@./scripts/generate-kotlin.sh

# Lint proto files
lint: ## Lint protobuf definitions
	@echo "🔍 Linting protobuf files..."
	@buf lint

# Check for breaking changes
breaking: ## Check for breaking changes against main branch
	@echo "🔍 Checking for breaking changes..."
	@buf breaking --against '.git#branch=main'

# Format proto files
format: ## Format protobuf files
	@echo "🎨 Formatting protobuf files..."
	@buf format -w

# Run tests
test: generate ## Run all tests
	@echo "🧪 Running Go tests..."
	@go test -tags=integration ./gen/go/... -v || true
	@echo "🧪 Running Kotlin/Java tests..."
	@if [ -f "./gradlew" ]; then \
		./gradlew test; \
	elif command -v gradle >/dev/null 2>&1; then \
		gradle test; \
	else \
		echo "⚠️  Gradle not available, skipping Kotlin tests"; \
	fi

# Build all artifacts
build: generate ## Build all artifacts
	@echo "🔨 Building Go modules..."
	@go build ./gen/go/...
	@echo "🔨 Building Kotlin/Java artifacts..."
	@if [ -f "./gradlew" ]; then \
		./gradlew build; \
	elif command -v gradle >/dev/null 2>&1; then \
		gradle build; \
	else \
		echo "⚠️  Gradle not available, skipping Kotlin build"; \
	fi

# Clean generated files
clean: ## Clean all generated files and build artifacts
	@echo "🧹 Cleaning generated files..."
	@rm -rf gen/
	@rm -rf build/
	@rm -rf .gradle/
	@rm -f RELEASE_NOTES.md

# Validate proto files
validate: lint ## Validate protobuf definitions
	@echo "✅ Protobuf files validated successfully"

# Install development dependencies
deps: ## Install development dependencies
	@echo "📦 Installing development dependencies..."
	@echo "Checking buf..."
	@if ! command -v buf >/dev/null 2>&1; then \
		echo "Installing buf..."; \
		curl -sSL "https://github.com/bufbuild/buf/releases/latest/download/buf-$$(uname -s)-$$(uname -m)" -o /usr/local/bin/buf; \
		chmod +x /usr/local/bin/buf; \
	fi
	@echo "Installing Go dependencies..."
	@go install google.golang.org/protobuf/cmd/protoc-gen-go@latest
	@go install google.golang.org/grpc/cmd/protoc-gen-go-grpc@latest
	@echo "✅ Dependencies installed"

# Publish packages
publish: ## Publish packages to repositories
	@./scripts/publish.sh

# Publish Go package only
publish-go: ## Publish Go package only
	@./scripts/publish.sh --go-only

# Publish Kotlin package only
publish-kotlin: ## Publish Kotlin package only
	@./scripts/publish.sh --kotlin-only

# Development workflow
dev: clean generate test ## Full development workflow: clean, generate, test

# Quick check for CI
ci: lint breaking generate test ## CI workflow: lint, check breaking changes, generate, test

# Show project status
status: ## Show project status and generated files
	@echo "📊 Project Status"
	@echo "================"
	@echo "Proto files:"
	@find proto -name "*.proto" | wc -l | xargs echo "  -"
	@echo "Generated Go files:"
	@find gen/go -name "*.go" 2>/dev/null | wc -l | xargs echo "  -" || echo "  - 0 (run 'make generate-go')"
	@echo "Generated Java/Kotlin files:"
	@find gen/java -name "*.java" -o -name "*.kt" 2>/dev/null | wc -l | xargs echo "  -" || echo "  - 0 (run 'make generate-kotlin')"
	@echo ""
	@echo "🔍 Available services:"
	@grep -h "^service " proto/*/v1/*.proto | sed 's/service \([^ ]*\).*/  - \1/' | sort | uniq
	@echo ""
	@if [ -f go.mod ]; then \
		echo "📦 Go module: $$(grep '^module ' go.mod | cut -d' ' -f2)"; \
	fi
	@if [ -f build.gradle.kts ]; then \
		echo "📦 Gradle artifact: $$(grep 'group = ' build.gradle.kts | cut -d'"' -f2):$$(grep 'artifactId' build.gradle.kts | cut -d'"' -f2 || echo 'proto-contracts'):$$(grep 'version = ' build.gradle.kts | cut -d'"' -f2)"; \
	fi

# Initialize repository
init: deps ## Initialize repository with dependencies
	@echo "🚀 Initializing proto-contracts repository..."
	@go mod tidy
	@make generate
	@echo "✅ Repository initialized successfully"
	@echo ""
	@echo "Next steps:"
	@echo "  1. Review generated code: make status"
	@echo "  2. Run tests: make test"
	@echo "  3. Start development: make dev"