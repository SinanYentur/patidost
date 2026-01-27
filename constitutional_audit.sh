
#!/bin/bash
# CONSTITUTIONAL AUDIT SCRIPT
# This script is the guardian of the project's DNA. It runs on every pre-commit and pre-merge hook.
# A failure in this script means the code is unconstitutional and cannot be merged.

set -e

PROJECT_ROOT=$(pwd)
FAIL=0

echo "헌법 감사 시작 (Constitutional Audit Started)"

# Helper function to run validation
run_validator() {
    local validator_name="$1"
    local validator_script="$2"

    if [ -f "$validator_script" ]; then
        echo "- Running: $validator_name..."
        if bash "$validator_script"; then
            echo "  => ✅ PASSED"
        else
            echo "  => ❌ FAILED"
            FAIL=1
        fi
    else
        echo "- ⚠️  SKIPPED: Validator script not found at $validator_script"
    fi
}

# --- ETHICS VALIDATION ---
run_validator "Data Minimization" ".ethics/validators/validate_data_minimization.sh"
run_validator "Consent Design" ".ethics/validators/validate_consent_design.sh"
run_validator "Accessibility (WCAG 2.1 AA)" ".ethics/validators/validate_accessibility.sh"

# --- SUSTAINABILITY VALIDATION ---
run_validator "Green Coding Standards" ".sustainability/validators/validate_green_coding.sh"

# --- TECHNICAL DEBT VALIDATION ---
echo "- Running: Static Analysis (Detekt)..."
if ./gradlew detekt; then
    echo "  => ✅ PASSED"
else
    echo "  => ❌ FAILED: Detekt found issues. See report for details."
    FAIL=1
fi

# --- FINAL VERDICT ---
if [ $FAIL -eq 1 ]; then
    echo -e "\n🚨 AUDIT FAILED. The commit violates the Project Constitution."
    echo "Review the errors above and correct them. The build is blocked."
    exit 1
else
    echo -e "\n✅ AUDIT PASSED. The code is compliant with the Project Constitution."
    exit 0
fi
