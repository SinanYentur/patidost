#!/usr/bin/env bash
REF_ID=$1
# CORE-001'i arayacak şekilde basitleştirilmiş test motoru
if [ "$REF_ID" == "CORE-001" ]; then
    exit 0
else
    exit 1
fi
