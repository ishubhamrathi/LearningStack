# AI Context

## Repository Purpose

This repository contains Java practice projects, including low-level design examples under `src/LLD`.

## README Update Rules For LLD Projects

When asked to create or update documentation for any project inside `src/LLD`, follow this structure.

### Root LLD README

File:

- `src/LLD/README.md`

Rules:

- Keep a simple project list.
- Each item must have:
  - project name
  - one-line description
  - relative link to that project's `README.md`
  - `Run Main` entry using the Java main class path

Example format:

- `[ParkingLot](./ParkingLot/README.md) - Basic parking lot design with spots, vehicles, tickets, and manager flow.`
  `Run Main: LLD.ParkingLot.Main`

### Per-Project README

For every LLD project such as `ParkingLot`, `TicTacToe`, `Logger`, or future projects like `ProxyDesignPattern`, create `src/LLD/<ProjectName>/README.md` with these sections in this order:

1. `# <ProjectName>`
2. Short description
3. `## How To Run`
4. `## Sample Test Case`
5. `## Design Principles Used`
6. `## LLD Design`
7. `## Files`

### Content Expectations

#### Short description

- One or two lines only.
- Describe what problem the project solves.

#### How To Run

- Give compile and run commands from the project root.
- Include the Java main class.
- If the project has a known run issue, mention it clearly.

#### Sample Test Case

- Provide a simple manual test flow.
- Prefer numbered steps.
- Include expected result.

#### Design Principles Used

- Mention the real principles or patterns used in the actual code.
- Examples:
  - Chain of Responsibility
  - Decorator
  - Strategy
  - Factory
  - Abstraction
  - Inheritance
  - Composition
  - Single Responsibility Principle
  - Open/Closed Principle
- Do not claim a pattern unless it is actually present in the implementation.

#### LLD Design

Describe:

- core entities
- service or manager layer
- interaction flow

Use short bullets and a numbered flow when possible.

#### Files

- List key source files.
- Add one-line purpose for each file.

## Future README Requests

If the user says something like:

- `update readme for project ProxyDesignPattern`
- `create readme for Adapter pattern`
- `document this LLD project`

Then:

1. inspect the code in that project first
2. identify the actual design pattern or principles used
3. update the project README using the structure above
4. update `src/LLD/README.md` if the project should appear in the root project list

## Scope

These instructions are repository-specific. Prefer these rules over generic README formatting when working inside this repo.
