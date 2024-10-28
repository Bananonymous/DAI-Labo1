---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Surbeck and N. Carbonara, based on DAI-COURSE-PRESENTATION-01
title: Presentation of FileCrypt - Practical Work 1
description: Presentation of FileCrypt, an app to encrypt and decrypt binary and text files for the DAI course at HEIG-VD, Switzerland
url: https://github.com/Bananonymous/DAI-Labo1
footer: '**HEIG-VD** - DAI Course 2024-2025 - CC BY-SA 4.0'
style: |
    :root {
        --color-background: #fff;
        --color-foreground: #333;
        --color-highlight: #f96;
        --color-dimmed: #888;
        --color-headings: #7d8ca3;
    }
    blockquote {
        font-style: italic;
    }
    table {
        width: 100%;
    }
    th:first-child {
        width: 15%;
    }
    h1, h2, h3, h4, h5, h6 {
        color: var(--color-headings);
    }
    h2, h3, h4, h5, h6 {
        font-size: 1.5rem;
    }
    h1 a:link, h2 a:link, h3 a:link, h4 a:link, h5 a:link, h6 a:link {
        text-decoration: none;
    }
    section:not([class=lead]) > p, blockquote {
        text-align: justify;
    }
    .three-columns {
        display: grid;
        grid-template-columns: repeat(3, minmax(0, 1fr));
        gap: 1rem;
    }
    .center {
        text-align: center;
    }
headingDivider: 4
-->

## FileCrypt

<!-- _class: lead -->

### Going further
- Encryption format to use (ie. AES, ARIA, Ascon),
- Passphrase to be used,
- Encrypt or decrypt multiple files,
- Saving key(s) to file
