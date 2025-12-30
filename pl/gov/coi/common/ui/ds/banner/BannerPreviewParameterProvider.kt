/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.banner

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.button.buttontext.ButtonTextData
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme

sealed class BannerData(
  val title: Label?,
  val bodyText: Label,
  iconResId: Int,
  iconColorProvider: @Composable () -> Color,
  iconContentDescription: Label,
  onCloseButtonClick: (() -> Unit)?,
  closeIconContentDescription: Label,
) {

  internal open val closeButtonData = onCloseButtonClick?.let { onCloseButtonClick ->
    ButtonIconData(
      iconResId = R.drawable.ab009_x_mark,
      iconColorProvider = { AppTheme.colors.neutral200 },
      onClick = onCloseButtonClick,
      contentDescription = closeIconContentDescription,
    )
  }

  internal val iconData: IconData = IconData.Standard(
    iconResId = iconResId,
    iconSize = IconSize.SIZE24,
    iconColorProvider = iconColorProvider,
    contentDescription = iconContentDescription,
  )

  class Info(
    title: Label? = null,
    bodyText: Label,
    iconContentDescription: Label,
    val buttonData: ButtonTextData? = null,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = Label.EMPTY,
  ) : BannerData(
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c1_info,
    iconColorProvider = { AppTheme.colors.supportBlue100 },
    iconContentDescription = iconContentDescription,
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
  )

  class Error(
    title: Label? = null,
    bodyText: Label,
    iconContentDescription: Label,
    val buttonData: ButtonTextData? = null,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = Label.EMPTY,
  ) : BannerData(
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c3_error_mark,
    iconColorProvider = { AppTheme.colors.supportRed100 },
    iconContentDescription = iconContentDescription,
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
  )

  class HighEmphasisInfo(
    title: Label? = null,
    bodyText: Label,
    iconContentDescription: Label,
    val buttonData: ButtonData? = null,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = Label.EMPTY,
  ) : BannerData(
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c1_info,
    iconColorProvider = { AppTheme.colors.white },
    iconContentDescription = iconContentDescription,
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
  ) {
    override val closeButtonData = onCloseButtonClick?.let { onCloseButtonClick ->
      ButtonIconData(
        iconResId = R.drawable.ab009_x_mark,
        iconColorProvider = { AppTheme.colors.white },
        onClick = onCloseButtonClick,
        contentDescription = closeIconContentDescription,
      )
    }
  }

  class HighEmphasisError(
    title: Label? = null,
    bodyText: Label,
    iconContentDescription: Label,
    val buttonData: ButtonData? = null,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = Label.EMPTY,
  ) : BannerData(
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c3_error_mark,
    iconColorProvider = { AppTheme.colors.white },
    iconContentDescription = iconContentDescription,
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
  ) {
    override val closeButtonData = onCloseButtonClick?.let { onCloseButtonClick ->
      ButtonIconData(
        iconResId = R.drawable.ab009_x_mark,
        iconColorProvider = { AppTheme.colors.white },
        onClick = onCloseButtonClick,
        contentDescription = closeIconContentDescription,
      )
    }
  }
}
