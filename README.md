<div align="center">

# Zeeshan Studio

### A modern glassmorphism Android IDE — built for your ideas, anywhere.

[![Build](https://img.shields.io/badge/Zeeshan%20Studio-Glassmorphism-00F2FE?style=for-the-badge)]()
[![Platform](https://img.shields.io/badge/Android-26%2B-4FACFE?style=for-the-badge)]()
[![Application%20ID](https://img.shields.io/badge/studio.vip.zeeshan-1A1D24?style=for-the-badge)]()

</div>

---

## What's new in Zeeshan Studio

Zeeshan Studio is a surface-level rebrand of **Android Code Studio** under the
Zeeshan brand. The proven LSP / Gradle / Termux foundation of Android Code
Studio is preserved end-to-end, and a fresh premium glassmorphism UI is layered
on top:

- Glassmorphism design system — translucent panels, soft gradient backdrops
  and rounded glass chips throughout the app
- Dark Glass / Light Glass themes with a new default (Dark Glass) using the
  palette from the Zeeshan Studio design language
- One-tap theme switcher in the editor sidebar and the project toolbar — flip
  the whole IDE between day and night instantly
- Branded splash screen with an animated entrance revealing the Z logo,
  app name and tagline
- New application icon — a glass chip with a bold **Z** monogram on a
  deep-purple-to-indigo gradient with cyan glows
- Application ID set to `studio.vip.zeeshan`
- GitHub Actions workflow that builds both **debug.apk** and **release.apk**
  artifacts on every push and attaches them to a GitHub Release on tagged runs

## Application identity

| | |
|---|---|
| App name | `Zeeshan Studio` |
| Application ID | `studio.vip.zeeshan` |
| Source repo | `github.com/zeeshanaly684-bot/android-code-studio-customize-` |
| Base | Android Code Studio (forked from `AndroidCSOfficial/android-code-studio`) |
| License | GNU GPL v3 (inherited from upstream) |

## Design language

### Dark Glass (default)

| Role | Value |
|---|---|
| Background | gradient `#0F0C20` → `#1A1D24` |
| Glass panel | `rgba(255,255,255,0.07)` |
| Accent | gradient `#00F2FE` → `#4FACFE` |
| Text (primary) | `#FFFFFF` |
| Text (secondary) | `#A0A5B5` |

### Light Glass

| Role | Value |
|---|---|
| Background | gradient `#E0E8F5` → `#F5F7FA` |
| Glass panel | `rgba(255,255,255,0.45)` |
| Accent | `#1865F2` |
| Text (primary) | `#121829` |
| Text (secondary) | `#5A657D` |

Translucent panels use `15–25%` background opacity with a `1dp` translucent
border and a `16–24dp` corner radius.

## Build

The release workflow is at
[`.github/workflows/release.yml`](.github/workflows/release.yml). It is the
recommended way to build APKs because it handles Java/toolchain setup,
generates a release keystore if needed, and uploads both **debug.apk** and
**release.apk** as workflow artifacts.

## License

This project is a derivative work of **Android Code Studio** by Akash Yadav
and the original contributors, used under the GNU General Public License v3.
See [LICENSE](LICENSE) for the full text.
