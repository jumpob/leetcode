---
name: leetcode-branch
description: LeetCodeの問題名（「2. Add Two Numbers」「2　Add Two Numbers」のような問題番号＋問題名）を受け取り、mainを派生元とする「2_add-two-numbers」形式のブランチを作成してcheckoutするスキル。ユーザーがLeetCodeの問題番号や問題名を渡して「ブランチ切って」「ブランチ作って」「この問題始める」「取り組む」と言ったとき、あるいは「番号. 英語の問題名」だけを貼り付けたときも、スキル名を明示していなくても使うこと。
---

# leetcode-branch

LeetCodeの問題ごとに、mainから作業ブランチを切ってcheckoutする。

## 入力

問題番号と問題名のセット。区切りは半角ピリオド＋スペース、全角スペース、半角スペースなど揺れる。

- `2. Add Two Numbers`
- `2　Add Two Numbers`（全角スペース）
- `141. Linked List Cycle`

## ブランチ名の規則

`<問題番号>_<問題名>`

- 問題名はすべて半角小文字にする
- 問題名内のスペースは半角ハイフン `-` に置き換える
- 区切りのピリオドは含めない
- 問題名にほかの記号（`(`、`'`、`,` など）があれば取り除く。ローマ数字などの英数字は残す

例:

| 入力 | ブランチ名 |
|---|---|
| `2. Add Two Numbers` | `2_add-two-numbers` |
| `2　Add Two Numbers` | `2_add-two-numbers` |
| `142. Linked List Cycle II` | `142_linked-list-cycle-ii` |

## 手順

1. 入力から番号と問題名を取り出し、上の規則でブランチ名を決める。番号か問題名が読み取れないときだけユーザーに聞く。
2. `git status --short` で未コミットの変更を確認する。変更があっても `git checkout -b` は変更を持ち越すので続行してよいが、最終報告で「未コミットの変更が新ブランチに持ち越されている」と伝える。
3. 同名ブランチが既にないか `git branch --list <ブランチ名>` で確認する。既にあれば作り直さず、ユーザーに「既存ブランチにcheckoutするか」を確認する。
4. mainを派生元にして作成・移動する。

   ```bash
   git checkout -b <ブランチ名> main
   ```

   派生元はローカルの `main`。作業中のブランチ（`study` など）からは派生させない。
5. `git branch --show-current` で現在のブランチを確認し、作成したブランチ名を短く報告する。

## しないこと

- commit、push、ファイル（問題フォルダなど）の作成はしない。頼まれたのはブランチの作成とcheckoutだけ。
