/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.controllers.provider

import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.ds.controllers.ControllersData

class ControllerFilterPreviewParameterProvider : CustomPreviewParameterProvider<ControllersData.Filter>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<ControllersData.Filter>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "ControllerFilterFirstSelected",
      value = provideControllerFilterFirstSelectedPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "ControllerFilterThirdSelected",
      value = provideControllerFilterThirdSelectedPreviewData(),
    ),
    ScreenShotTestData(
      screenShotTestName = "ControllerFilterShortLabel",
      value = provideControllerFilterShortLabelPreviewData(),
    ),
  )
}

private fun provideControllerFilterFirstSelectedPreviewData() =
  ControllersData.Filter(
    items = listOf(
      "Główne",
      "Tymczasowe",
      "Niezdeklarowane",
      "Nieważne",
    ).map { it.toLabel(tag = it) },
    selectedItemIndex = 0,
    onClick = {},
  )

private fun provideControllerFilterThirdSelectedPreviewData() =
  ControllersData.Filter(
    items = listOf(
      "Główne",
      "Tymczasowe",
      "Niezdeklarowane",
      "Nieważne",
    ).map { it.toLabel(tag = it) },
    selectedItemIndex = 2,
    onClick = {},
  )

private fun provideControllerFilterShortLabelPreviewData() =
  ControllersData.Filter(
    items = listOf(
      "a",
      "b",
      "c",
      "d",
      "e",
      "f",
      "g",
      "h",
      "i",
      "j",
      "k",
    ).map { it.toLabel(tag = it) },
    selectedItemIndex = 1,
    onClick = {},
  )
