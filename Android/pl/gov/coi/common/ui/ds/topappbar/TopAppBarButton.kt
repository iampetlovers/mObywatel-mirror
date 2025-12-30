/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.topappbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
internal fun TopAppBarButton(buttonIconData: ButtonIconData) {
  Box(
    modifier = Modifier
      .size(AppTheme.dimensions.spacing600)
      .clickable {
        buttonIconData.onClick()
      },
    contentAlignment = Alignment.Center,
  ) {
    ButtonIcon(data = buttonIconData)
  }
}

@Composable
internal fun MenuType?.CreateMenuButtons() = when (this) {
  is MenuType.Icon -> TopAppBarButton(buttonIconData = menuButtonData.getButton())
  is MenuType.IconList -> menuIconList.forEach { buttonData ->
    TopAppBarButton(buttonIconData = buttonData.getButton())
  }

  null -> Box(modifier = Modifier.size(AppTheme.dimensions.spacing600))
}

@Composable
internal fun NavigationButtonData?.CreateNavigationButton() = when (this) {
  null -> Box(modifier = Modifier.size(AppTheme.dimensions.spacing600))
  else -> TopAppBarButton(
    buttonIconData = ButtonIconData(
      iconResId = this.icon.iconResId,
      iconColorProvider = { AppTheme.colors.neutral200 },
      contentDescription = this.icon.contentDescription,
      onClick = this.onClick,
    ),
  )
}
