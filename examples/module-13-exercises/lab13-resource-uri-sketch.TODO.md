# Lab 13 — Design the Resource URI Table

## Name the Nouns

Resources: customers (top level) and interactions (nested beneath a customer).

## URI Table

/api/customers for the collection, /api/customers/CUS-1001 for the item, /api/customers/CUS-1001/interactions for the sub-resource.

## Fix a Bad URI

/getCustomerById?id=CUS-1001 becomes GET /api/customers/CUS-1001 — the verb moves into the method.

## Scope

Design only — no controller and no OpenAPI YAML written yet.
## Scope
Pre-lab only — do not finish the full graded lab in this exercise.