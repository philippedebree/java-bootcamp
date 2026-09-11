# Lab 13 — Write the Error Contract

## Error Fields

Every error returns timestamp, status, code, message, and path.

## Correlation

correlationId echoes the inbound X-Correlation-Id header, defaulting to a generated value.

## Two Examples

404 gives code CUSTOMER_NOT_FOUND for CUS-9999; 400 gives VALIDATION_FAILED listing the offending fields.

## Leak Check

Never included: stack traces, raw SQL, internal hostnames, or another customer's data.
## Scope
Pre-lab only — do not finish the full graded lab in this exercise.