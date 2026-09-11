# Lab 13 — Plan Collections and Versioning

## Query Parameters

page (default 0), size (default 20, max 100), sort as field,direction, and status as an optional filter.

## Response Envelope

content plus page, size, totalElements, and totalPages so the client can render a pager.

## Version Choice

URI versioning as /api/v1/... — visible in logs and trivially routable, which suits this cohort's tooling.

## Breaking Change

Breaking: removing or renaming a field, or changing its type. Non-breaking: adding an optional field.
## Scope
Pre-lab only — do not finish the full graded lab in this exercise.