# Lab 13 — Map Methods to Status Codes

## Method Table

GET on collection and item; POST on the collection; PUT and DELETE on the item.

## Success Codes

GET 200, POST 201 with Location: /api/customers/CUS-1003, PUT 200, DELETE 204 with no body.

## Failure Codes

GET /api/customers/CUS-9999 returns 404; a malformed create body returns 400.

## Safe vs Idempotent

GET safe and idempotent; PUT and DELETE idempotent but not safe; POST neither.
## Scope
Pre-lab only — do not finish the full graded lab in this exercise.