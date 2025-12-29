/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.snackbar.provider

import pl.gov.coi.common.ui.ds.snackbar.SnackBarData
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class SnackBarPreviewParameterProvider : CustomPreviewParameterProvider<SnackBarData>() {

  override val screenShotTestValues: Sequence<ScreenShotTestData<SnackBarData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "SnackBarDataSimple",
      value = SnackBarData.Default(
        messageLabel = "Single-line snackbar".toLabel(),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SnackBarDataSimple",
      value = SnackBarData.Default(
        ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laore").toLabel(),
      ),
    ),
    ScreenShotTestData(
      screenShotTestName = "SnackBarDataClosable",
      value = SnackBarData.DefaultWithIcon(
        messageLabel = "Single-line snackbar with close affordance".toLabel(),
      ) {},
    ),
    ScreenShotTestData(
      screenShotTestName = "SnackBarDataClosable",
      value = SnackBarData.DefaultWithIcon(
        ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laore").toLabel(),
      ) {},
    ),
    ScreenShotTestData(
      screenShotTestName = "SnackBarDataDefaultWithIcon",
      value = SnackBarData.DefaultWithIcon(
        ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laore." +
          " Lorem ipsum dolor sit amet.").toLabel(),
      ),
    ),
  )
}
