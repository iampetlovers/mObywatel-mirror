/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.custom.documentrow

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.singlecard.SingleCardClickableRadioButtonState
import pl.gov.coi.common.ui.ds.singlecard.toIconState
import pl.gov.coi.common.ui.ds.statusbadge.StatusBadgeData

data class DocumentRowData(
  val testTag: String? = null,
  @DrawableRes val iconResId: Int,
  val iconColorProvider: @Composable () -> Color = { Color.Unspecified },
  val title: Label,
  val description: Label? = null,
  val modifier: Modifier = Modifier,
  val badgeData: StatusBadgeData.WithIcon?,
  val onClick: () -> Unit,
) {
  internal val iconData: IconData = IconData.Standard(
    testTag = testTag?.let { tag -> tag + "Icon" },
    iconResId = iconResId,
    iconSize = IconSize.SIZE24,
    iconColorProvider = iconColorProvider,
    contentDescription = Label.EMPTY,
    iconState = SingleCardClickableRadioButtonState.ENABLED.toIconState(),
  )

  internal val trailingIcon = IconData.Standard(
    testTag = testTag?.let { tag -> tag + "TrailingIcon" },
    iconResId = DEFAULT_TRAILING_ICON_RES_ID,
    iconSize = IconSize.SIZE24,
    iconColorProvider = DEFAULT_TRAILING_ICON_COLOR_PROVIDER,
    iconState = SingleCardClickableRadioButtonState.ENABLED.toIconState(),
    contentDescription = DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION,
  )

  private companion object {
    val DEFAULT_TRAILING_ICON_RES_ID = R.drawable.ab006_chevron_right
    val DEFAULT_TRAILING_ICON_COLOR_PROVIDER: @Composable () -> Color = { Color.Unspecified }
    val DEFAULT_TRAILING_ICON_CONTENT_DESCRIPTION = Label.EMPTY
  }
}
