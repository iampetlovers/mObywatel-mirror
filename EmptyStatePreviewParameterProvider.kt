/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.emptystate.provider

import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.ds.emptystate.EmptyStateData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class EmptyStatePreviewParameterProvider : CustomPreviewParameterProvider<EmptyStateData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<EmptyStateData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "EmptyStateDataNoTitle",
      value = provideEmptyStateDataNoTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "EmptyStateStateDataWithTitle",
      value = provideEmptyStateDataWithTitle(),
    ),
    ScreenShotTestData(
      screenShotTestName = "EmptyStateDataStandardWithButton",
      value = provideEmptyStateDataWithButton(),
    ),
    ScreenShotTestData(
      screenShotTestName = "EmptyStateDataNoTitleWithButton",
      value = provideEmptyStateDataNoTitleWithButton(),
    ),
  )

  private fun provideEmptyStateDataWithTitle() = EmptyStateData(
    title = "Title section (optional)".toLabel(),
    body = "Body section".toLabel(),
  )

  private fun provideEmptyStateDataNoTitle() = EmptyStateData(
    body = "Body section".toLabel(),
  )

  private fun provideEmptyStateDataWithButton() = EmptyStateData(
    title = "Title section (optional)".toLabel(),
    body = "Body section".toLabel(),
    buttonData = ButtonData(
      buttonSize = ButtonSize.Small,
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Tertiary small button (optional)".toLabel(),
      ),
      onClick = {},
    ),
  )

  private fun provideEmptyStateDataNoTitleWithButton() = EmptyStateData(
    body = "Body section".toLabel(),
    buttonData = ButtonData(
      buttonSize = ButtonSize.Small,
      buttonVariant = ButtonVariant.Tertiary,
      buttonType = ButtonType.WithText(
        label = "Tertiary small button (optional)".toLabel(),
      ),
      onClick = {},
    ),
  )
}
