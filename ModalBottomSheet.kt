/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.bottomnavigation.provider

import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.bottomnavigation.BottomNavigationData
import pl.gov.coi.common.ui.ds.bottomnavigation.BottomNavigationItem
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class BottomNavigationPreviewParameterProvider :
  CustomPreviewParameterProvider<BottomNavigationData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<BottomNavigationData>> =
    sequenceOf(
      ScreenShotTestData(
        screenShotTestName = "BottomNavigationFiveElements",
        value = BottomNavigationData(
          items = listOf(
            BottomNavigationItem(
              label = "Start".toLabel(),
              unselectedIconResId = R.drawable.ab001_home,
              selectedIconResId = R.drawable.b001_home,
              onClickAction = {},
            ),
            BottomNavigationItem(
              label = "Dokumenty".toLabel(),
              unselectedIconResId = R.drawable.ad005_framed_person,
              selectedIconResId = R.drawable.b002_framed_person,
              onClickAction = {},
            ),
            BottomNavigationItem(
              label = "Usługi".toLabel(),
              unselectedIconResId = R.drawable.ac001_services,
              selectedIconResId = R.drawable.b004_services,
              onClickAction = {},
            ),
            BottomNavigationItem(
              label = "Kod QR".toLabel(),
              unselectedIconResId = R.drawable.ai001_scanner_qr,
              selectedIconResId = R.drawable.b003_scanner_qr,
              onClickAction = {},
            ),
            BottomNavigationItem(
              label = "Więcej".toLabel(),
              unselectedIconResId = R.drawable.ab010_more,
              selectedIconResId = R.drawable.b005_more,
              onClickAction = {},
            ),
          ),
          selectedItemIndex = 0,
        ),
      ),
      ScreenShotTestData(
        screenShotTestName = "BottomNavigationTwoElements",
        value = BottomNavigationData(
          items = listOf(
            BottomNavigationItem(
              label = "Start".toLabel(),
              unselectedIconResId = R.drawable.ab001_home,
              selectedIconResId = R.drawable.b001_home,
              onClickAction = {},
            ),
            BottomNavigationItem(
              label = "Więcej".toLabel(),
              unselectedIconResId = R.drawable.ab010_more,
              selectedIconResId = R.drawable.b005_more,
              onClickAction = {},
            ),
          ),
          selectedItemIndex = 0,
        ),
      ),
    )
}
