/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.supportpage

import androidx.annotation.DrawableRes
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.custom.icon.BackgroundShape
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme

class SupportPageData<CONTENT_DATA>(
  internal val topBarTitle: Label,
  @DrawableRes topBarIconMainResId: Int?,
  onTopBarIconMainClick: (() -> Unit)?,
  @DrawableRes topBarIconMenuResId: Int?,
  onTopBarIconMenuClick: (() -> Unit)?,
  @DrawableRes iconResId: Int,
  iconContentDescription: Label,
  internal val title: Label,
  internal val message: Label?,
  internal val contentData: CONTENT_DATA,
  internal val buttonData: ButtonData?,
) {
  internal val iconData: IconData.Background = IconData.Background(
    iconResId = iconResId,
    backgroundSize = IconSize.SIZE96,
    iconSize = IconSize.SIZE64,
    iconColorProvider = { AppTheme.colors.primary900 },
    backgroundColorProvider = { AppTheme.colors.secondary900 },
    backgroundShape = BackgroundShape.Rounded,
    contentDescription = iconContentDescription,
  )

  internal val mainButtonData: ButtonIconData? =
    topBarIconMainResId?.let {
      ButtonIconData(
        
        iconResId = it,
        iconColorProvider = { AppTheme.colors.neutral200 },
        onClick = onTopBarIconMainClick ?: {},
      )
    }

  internal val menuButtonData: ButtonIconData? =
    topBarIconMenuResId?.let {
      ButtonIconData(
        
        iconResId = it,
        iconColorProvider = { AppTheme.colors.neutral200 },
        onClick = onTopBarIconMenuClick ?: {},
      )
    }
}
