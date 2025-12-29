/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.alert

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme

sealed class AlertData(
  val testTag: String?,
  val alertContentDescription: Label,
  val title: Label?,
  val bodyText: Label,
  iconResId: Int,
  iconColorProvider: @Composable () -> Color,
  onCloseButtonClick: (() -> Unit)?,
  closeIconContentDescription: Label,
  val alertButtonData: AlertButtonData?,
) {

  internal val closeButtonData = onCloseButtonClick?.let { onCloseButtonClick ->
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
    contentDescription = null,
  )

  class Info(
    testTag: String? = null,
    alertContentDescription: Label = CommonUILabelProvider.commonAccessibilityInformation(),
    title: Label? = null,
    bodyText: Label,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = CommonUILabelProvider.commonAccessibilityCloseInformation(),
    alertButtonData: AlertButtonData? = null,
  ) : AlertData(
    testTag = testTag,
    alertContentDescription = alertContentDescription,
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c1_info,
    iconColorProvider = { AppTheme.colors.supportBlue100 },
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
    alertButtonData = alertButtonData,
  )

  class Warning(
    testTag: String? = null,
    alertContentDescription: Label = CommonUILabelProvider.commonAccessibilityWarningInformation(),
    title: Label? = null,
    bodyText: Label,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = CommonUILabelProvider.commonAccessibilityCloseWarningInformation(),
    alertButtonData: AlertButtonData? = null,
  ) : AlertData(
    testTag = testTag,
    alertContentDescription = alertContentDescription,
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c2_warning_mark,
    iconColorProvider = { AppTheme.colors.supportOrange100 },
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
    alertButtonData = alertButtonData,
  )

  class Success(
    testTag: String? = null,
    alertContentDescription: Label = CommonUILabelProvider.commonAccessibilitySuccessInformation(),
    title: Label? = null,
    bodyText: Label,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = CommonUILabelProvider.commonAccessibilityCloseSuccessInformation(),
    alertButtonData: AlertButtonData? = null,
  ) : AlertData(
    testTag = testTag,
    alertContentDescription = alertContentDescription,
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c4_success,
    iconColorProvider = {
      val alertSuccessIconColor = Color(0xFF427639)
      alertSuccessIconColor
    },
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
    alertButtonData = alertButtonData,
  )

  class Error(
    testTag: String? = null,
    alertContentDescription: Label = CommonUILabelProvider.commonAccessibilityErrorInformation(),
    title: Label? = null,
    bodyText: Label,
    onCloseButtonClick: (() -> Unit)? = null,
    closeIconContentDescription: Label = CommonUILabelProvider.commonAccessibilityCloseSuccessInformation(),
    alertButtonData: AlertButtonData? = null,
  ) : AlertData(
    testTag = testTag,
    alertContentDescription = alertContentDescription,
    title = title,
    bodyText = bodyText,
    iconResId = R.drawable.c3_error_mark,
    iconColorProvider = { AppTheme.colors.supportRed100 },
    onCloseButtonClick = onCloseButtonClick,
    closeIconContentDescription = closeIconContentDescription,
    alertButtonData = alertButtonData,
  )
}
