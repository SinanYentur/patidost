# AI ENGINEERING GOVERNANCE CONTRACT

## CORE RULE: NO HARDCODING
- NEVER use hardcoded versions in build files.
- ALWAYS use `libs.versions.toml` catalog references.
- If a library is missing in TOML, DO NOT improvise. Update TOML first.

## WORK PROTOCOL
1. **Analyze:** Check `libs.versions.toml` before writing any Gradle code.
2. **Verify:** Ensure alias names match exactly (kebab-case in TOML -> dot.notation in KTS).
3. **Implement:** Write the code using only verified references.
