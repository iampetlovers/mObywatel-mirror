/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.menus.provider

import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.menus.MenuData
import pl.gov.coi.common.ui.ds.menus.MenuItem
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData

class MenuPreviewParameterProvider : CustomPreviewParameterProvider<MenuData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<MenuData>>
    get() = sequenceOf(
      ScreenShotTestData(
        screenShotTestName = "Menu",
        value = provideMenuData(),
      ),
    )

  private fun provideMenuData() = MenuData(
    isMenuVisible = true,
    onMenuClose = {},
    items = listOf(
      MenuItem(
        label = "Opcja 1".toLabel(),
        leftIconResId = R.drawable.ah001_like,
        rightIconResId = R.drawable.ah001_like,
        onItemClick = {},
      ),
      MenuItem(
        label = "Opcja 2".toLabel(),
        leftIconResId = R.drawable.aa002_delete,
        rightIconResId = R.drawable.aa002_delete,
        onItemClick = {},
      ),
      MenuItem(
        label = "Opcja 3".toLabel(),
        leftIconResId = R.drawable.ah002_dislike,
        rightIconResId = R.drawable.ah002_dislike,
        onItemClick = {},
      ),
    ),
  )
}
