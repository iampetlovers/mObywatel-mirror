/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.inputdatetime.provider

import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.inputdatetime.InputDateTimeData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class InputDateTimePreviewParameterProvider : CustomPreviewParameterProvider<InputDateTimeData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<InputDateTimeData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "InputDateEnabledPlaceholder",
      value = provideInputDateEnabledPlaceholderPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "InputDateEnabledSelectedDate",
      value = provideInputDateEnabledSelectedDatePreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "InputDateErrorPlaceholder",
      value = provideInputDateErrorPlaceholderPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "InputDateErrorSelectedDate",
      value = provideInputDateErrorSelectedDatePreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "InputDateErrorLongMessage",
      value = provideInputDateErrorLongMessagePreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "InputDateDisabledPlaceholder",
      value = provideInputDateDisabledPlaceholderPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "InputDateDisabledSelectedDate",
      value = provideInputDateDisabledSelectedDatePreviewData(),
    ),
  )
}

fun provideInputDateEnabledPlaceholderPreviewData() =
  InputDateTimeData(
    label = "Label".toLabel(""),
    helperText = "Helper text.".toLabel(""),
    type = InputDateTimeData.Type.Date,
    onClick = {},
  )

fun provideInputDateEnabledSelectedDatePreviewData() =
  InputDateTimeData(
    inputText = "29.04.2024",
    label = "Label".toLabel(""),
    type = InputDateTimeData.Type.Date,
    helperText = "Helper text.".toLabel(""),
    onClick = {},
  )

fun provideInputDateErrorPlaceholderPreviewData() =
  InputDateTimeData(
    label = "Label".toLabel(""),
    helperText = "Helper text.".toLabel(""),
    type = InputDateTimeData.Type.Date,
    validationState = ValidationState.Invalid(
      message = "Error text.".toLabel(""),
    ),
    onClick = {},
  )

fun provideInputDateErrorSelectedDatePreviewData() =
  InputDateTimeData(
    inputText = "29.04.2024",
    label = "Label".toLabel(""),
    type = InputDateTimeData.Type.Date,
    helperText = "Helper text.".toLabel(""),
    validationState = ValidationState.Invalid(
      message = "Error text.".toLabel(""),
    ),
    onClick = {},
  )

fun provideInputDateErrorLongMessagePreviewData() =
  InputDateTimeData(
    inputText = "29.04.2024",
    label = "Label".toLabel(""),
    type = InputDateTimeData.Type.Date,
    helperText = "Helper text.".toLabel(""),
    validationState = ValidationState.Invalid(
      message = ("Podczas walidacji tekst pomocniczy zostaje zastąpiony tekstem błędu (komponent validation error). " +
        "Validation error dla komunikatu o długości powyżej jednej linii.").toLabel(""),
    ),
    onClick = {},
  )

fun provideInputDateDisabledPlaceholderPreviewData() =
  InputDateTimeData(
    label = "Label".toLabel(""),
    type = InputDateTimeData.Type.Date,
    helperText = "Helper text.".toLabel(""),
    enabled = false,
    onClick = {},
  )

fun provideInputDateDisabledSelectedDatePreviewData() =
  InputDateTimeData(
    inputText = "29.04.2024",
    label = "Label".toLabel(""),
    type = InputDateTimeData.Type.Date,
    helperText = "Helper text.".toLabel(""),
    enabled = false,
    onClick = {},
  )
