/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.resultmodal.provider

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.resultmodal.ResultModalData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.theme.AppTheme

class ResultModalPreviewParameterProvider : CustomPreviewParameterProvider<ResultModalData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<ResultModalData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "ResultModalData",
      value = provideResultModalData(),
    ),
  )

  private fun provideResultModalData() = ResultModalData(
    iconRes = R.drawable.f4_success,
    iconColorProvider = { AppTheme.colors.supportGreen100 },
    iconContentDescription = Label.EMPTY,
    title = "Title Roboto Medium 20".toLabel(),
    dataTitle1 = "Data title 2 Roboto Regular 16".toLabel(),
    data1 = "Data 1 Roboto Medium 18\nData 1 Roboto Medium 18".toLabel(),
    dataTitle2 = "Data title 2 Roboto Regular 16".toLabel(),
    data2 = "Data 2 Roboto Medium 18".toLabel(),
    primaryButton = ButtonData(
      buttonSize = ButtonSize.Large(),
      buttonVariant = ButtonVariant.Primary,
      buttonType = ButtonType.WithText(
        label = "Primary button".toLabel(),
      ),
      onClick = {},
    ),
    secondaryButton = ButtonData(
      buttonSize = ButtonSize.Large(),
      buttonVariant = ButtonVariant.Secondary(),
      buttonType = ButtonType.WithText(
        label = "Secondary button".toLabel(),
      ),
      onClick = {},
    ),
    tertiaryButton = ButtonData(
      buttonSize = ButtonSize.Large(),
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Tertiary button".toLabel(),
      ),
      onClick = {},
    ),
    closeIconContentDescription = Label.EMPTY,
    closeAction = {},
  )
}
