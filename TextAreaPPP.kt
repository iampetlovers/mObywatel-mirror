/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.textarea.provider

import pl.gov.coi.common.ui.ds.textarea.CounterState
import pl.gov.coi.common.ui.ds.textarea.TextAreaData
import pl.gov.coi.common.ui.ds.textarea.TextAreaDataState
import pl.gov.coi.common.ui.ds.textarea.TextAreaType
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class TextAreaPPP : CustomPreviewParameterProvider<TextAreaData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<TextAreaData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "FlexibleEmpty",
      value = TextAreaData(
        type = TextAreaType.Flexible(),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Hidden,
        onValueChanged = {},
        state = TextAreaDataState.Default(),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FlexibleWithCounterAndLabel",
      value = TextAreaData(
        label = "Flexible - WithCounterAndLabel".toLabel(),
        type = TextAreaType.Flexible(),
        state = TextAreaDataState.Default(),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Visible(
          maxLength = 400,
          onCharsLimitReached = {},
        ),
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FlexibleWithLabel",
      value = TextAreaData(
        label = "Flexible - WithLabel".toLabel(),
        type = TextAreaType.Flexible(),
        state = TextAreaDataState.Default(),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Hidden,
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FlexibleWithCounterLabelAndHelper",
      value = TextAreaData(
        label = "Flexible - WithCounterLabelAndHelper".toLabel(),
        type = TextAreaType.Flexible(),
        state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Hidden,
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FlexibleWithCounterLabelAndHelperDisabled",
      value = TextAreaData(
        label = "Flexible - FlexibleWithCounterLabelAndHelperDisabled".toLabel(),
        type = TextAreaType.Flexible(),
        enabled = false,
        state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Visible(
          maxLength = 200,
        ),
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FlexibleWithCounterAndContentDisabled",
      value = TextAreaData(
        label = "Flexible - FlexibleWithCounterAndContentDisabled".toLabel(),
        type = TextAreaType.Flexible(maxLines = 6),
        enabled = false,
        state = TextAreaDataState.Default(),
        counterState = CounterState.Visible(
          maxLength = 255,
        ),
        onValueChanged = {},
        content = "TextArea content",
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FlexibleWithCounterLabelAndInvalid",
      value = TextAreaData(
        label = "Flexible - WithCounterLabelAndInvalid".toLabel(),
        type = TextAreaType.Flexible(),
        state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Visible(
          maxLength = 400,
          onCharsLimitReached = {},
        ),
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FixWithCounterLabelAndHelper",
      value = TextAreaData(
        label = "Fix - WithCounterLabelAndHelper".toLabel(),
        type = TextAreaType.Fix(),
        state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
        hint = "Fix text area - hint".toLabel(),
        counterState = CounterState.Hidden,
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FixEmpty",
      value = TextAreaData(
        label = "Fix - FixEmpty".toLabel(),
        type = TextAreaType.Fix(),
        state = TextAreaDataState.Default(helperLabel = "HelperText".toLabel()),
        hint = "Fix text area - hint".toLabel(),
        counterState = CounterState.Hidden,
        onValueChanged = {},
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "FixWithCounterLabelAndInvalid",
      value = TextAreaData(
        label = "Fix - WithCounterLabelAndInvalid".toLabel(),
        type = TextAreaType.Flexible(),
        state = TextAreaDataState.Error(errorLabel = "Invalid Fix".toLabel()),
        hint = "Flexible text area - hint".toLabel(),
        counterState = CounterState.Visible(
          maxLength = 400,
          onCharsLimitReached = {},
        ),
        onValueChanged = {},
      ),
    ),
  )
}
