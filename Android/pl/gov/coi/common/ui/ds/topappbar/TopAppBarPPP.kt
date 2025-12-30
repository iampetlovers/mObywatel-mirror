/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.topappbar

import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.progressbar.ProgressBarData
import pl.gov.coi.common.ui.ds.topappbar.MenuType.MenuButtonData
import pl.gov.coi.common.ui.ds.topappbar.MenuType.MenuButtonData.MenuIcon
import pl.gov.coi.common.ui.preview.CustomPreviewParameterProvider
import pl.gov.coi.common.ui.preview.ScreenShotTestData
import pl.gov.coi.common.ui.theme.AppTheme

private val NOTIFICATION = object : MenuIcon {
  override val iconResId = R.drawable.ab013_notifications
  override val contentDescription = "Powiadomienia".toLabel("Powiadomienia")
}

class TopAppBarPPP : CustomPreviewParameterProvider<TopAppBarData>() {
  override val screenShotTestValues: Sequence<ScreenShotTestData<TopAppBarData>> = sequenceOf(
    ScreenShotTestData(
      screenShotTestName = "MediumTopAppBar",
      value = getMediumTopAppBar(),
    ),
    ScreenShotTestData(
      screenShotTestName = "LargeTopAppBar",
      value = getLargeTopAppBar(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallDefaultTopAppBar - Center",
      value = getSmallDefaultTopAppBar(titleAlignment = TitleAlignment.Center),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallDefaultTopAppBar - Left",
      value = getSmallDefaultTopAppBar(titleAlignment = TitleAlignment.Left),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallDefaultIconListTopAppBar - Center",
      value = getSmallDefaultIconListTopAppBar(titleAlignment = TitleAlignment.Center),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallDefaultIconListTopAppBar - Left",
      value = getSmallDefaultIconListTopAppBar(titleAlignment = TitleAlignment.Left),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallDefaultLogoNoTitleTopAppBar",
      value = getSmallDefaultNoTitleTopAppBar(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallDefaultLogoNoActionsTopAppBar",
      value = getSmallDefaultNoActionsTopAppBar(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallDefaultLogoTopNoNavigationAppBar",
      value = getSmallDefaultNoNavigationTopAppBar(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallLogoTopAppBar",
      value = getSmallLogoTopAppBar(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallSygnetTopAppBar",
      value = getSmallSygnetTopAppBar(),
    ),
    ScreenShotTestData(
      screenShotTestName = "SmallDefaultWithProgressTopAppBar",
      value = getSmallDefaultWithProgressTopAppBar(),
    ),
  )

  private fun getSmallDefaultNoTitleTopAppBar(): TopAppBarData = TopAppBarData.Small.Default(
    alignment = TitleAlignment.Center,
    navigationButtonData = NavigationButtonData(
      icon = NavigationButtonData.Icon.BACK_ARROW,
      onClick = {},
    ),
    menuType = MenuType.Icon(
      menuButtonData = MenuButtonData(
        icon = NOTIFICATION,
        iconColorProvider = { AppTheme.colors.neutral200 },
        onClick = {},
      ),
    ),
  )

  private fun getSmallDefaultNoActionsTopAppBar(): TopAppBarData = TopAppBarData.Small.Default(
    title = "Small Title".toLabel(),
    alignment = TitleAlignment.Center,
    navigationButtonData = NavigationButtonData(
      icon = NavigationButtonData.Icon.BACK_ARROW,
      onClick = {},
    ),
  )

  private fun getSmallDefaultNoNavigationTopAppBar(): TopAppBarData = TopAppBarData.Small.Default(
    title = "Small Title".toLabel(),
    alignment = TitleAlignment.Center,
    menuType = MenuType.Icon(
      menuButtonData = MenuButtonData(
        icon = NOTIFICATION,
        iconColorProvider = { AppTheme.colors.neutral200 },
        onClick = {},
      ),
    ),
  )

  private fun getSmallDefaultWithProgressTopAppBar(): TopAppBarData = TopAppBarData.Small.Default(
    title = "Small Title".toLabel(),
    alignment = TitleAlignment.Center,
    navigationButtonData = NavigationButtonData(
      icon = NavigationButtonData.Icon.BACK_ARROW,
      onClick = {},
    ),
    menuType = MenuType.Icon(
      menuButtonData = MenuButtonData(
        icon = NOTIFICATION,
        onClick = {},
      ),
    ),
    progressBarData = ProgressBarData.IndicatorBar(
      value = 45,
      label = "45%".toLabel(),
    ),
  )

  private fun getSmallSygnetTopAppBar(): TopAppBarData = TopAppBarData.Small.Sygnet(
    menuType = MenuType.Icon(
      menuButtonData = MenuButtonData(
        icon = NOTIFICATION,
        onClick = {},
      ),
    ),
  )

  private fun getSmallLogoTopAppBar(): TopAppBarData = TopAppBarData.Small.Logo()

  private fun getSmallDefaultTopAppBar(
    titleAlignment: TitleAlignment,
  ): TopAppBarData = TopAppBarData.Small.Default(
    title = "Small Title".toLabel(),
    alignment = titleAlignment,
    navigationButtonData = NavigationButtonData(
      icon = NavigationButtonData.Icon.BACK_ARROW,
      onClick = {},
    ),
    menuType = MenuType.Icon(
      menuButtonData = MenuButtonData(
        icon = NOTIFICATION,
        onClick = {},
      ),
    ),
  )

  private fun getSmallDefaultIconListTopAppBar(
    titleAlignment: TitleAlignment,
  ): TopAppBarData = TopAppBarData.Small.Default(
    title = "Small Title".toLabel(),
    alignment = titleAlignment,
    navigationButtonData = NavigationButtonData(
      icon = NavigationButtonData.Icon.BACK_ARROW,
      onClick = {},
    ),
    menuType = MenuType.IconList(
      listOf(
        MenuButtonData(
          icon = MenuButtonData.DefaultMenuIcon.CLOSE,
          iconColorProvider = { AppTheme.colors.neutral200 },
          onClick = {},
        ),
        MenuButtonData(
          icon = NOTIFICATION,
          iconColorProvider = { AppTheme.colors.neutral200 },
          onClick = {},
        ),
      ),
    ),

  )

  private fun getLargeTopAppBar() = TopAppBarData.Large(
    title = "Large Large Large Large Large Large ".toLabel(),
    navigationButtonData = NavigationButtonData(
      icon = NavigationButtonData.Icon.BACK_ARROW,
      onClick = {},
    ),
    menuType = MenuType.IconList(
      menuIconList = listOf(
        MenuButtonData(
          icon = MenuButtonData.DefaultMenuIcon.EDIT,
          onClick = {},
        ),
        MenuButtonData(
          icon = MenuButtonData.DefaultMenuIcon.CLOSE,
          onClick = {},
        ),
        MenuButtonData(
          icon = NOTIFICATION,
          onClick = {},
        ),
      ),
    ),
  )

  private fun getMediumTopAppBar() = TopAppBarData.Medium(
    title = "Medium Medium Medium Medium Medium Medium".toLabel(),
    navigationButtonData = NavigationButtonData(
      icon = NavigationButtonData.Icon.BACK_ARROW,
      onClick = {},
    ),
    menuType = MenuType.IconList(
      menuIconList = listOf(
        MenuButtonData(
          icon = MenuButtonData.DefaultMenuIcon.QUESTION_MARK,
          onClick = {},
        ),
        MenuButtonData(
          icon = MenuButtonData.DefaultMenuIcon.EDIT,
          onClick = {},
        ),
        MenuButtonData(
          icon = NOTIFICATION,
          onClick = {},
        ),
      ),
    ),
  )

}
