/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.resultmodal

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.theme.AppTheme

class ResultModalData(
  iconRes: Int,
  iconColorProvider: @Composable () -> Color,
  iconContentDescription: Label,
  val title: Label,
  val dataTitle1: Label,
  val data1: Label,
  val dataTitle2: Label,
  val data2: Label,
  val primaryButton: ButtonData?,
  val secondaryButton: ButtonData?,
  val tertiaryButton: ButtonData?,
  closeIconContentDescription: Label,
  closeAction: () -> Unit,
) {
  val closeIconButtonData = ButtonIconData(
    iconResId = R.drawable.ab009_x_mark,
    iconColorProvider = { AppTheme.colors.neutral500 },
    contentDescription = closeIconContentDescription,
    onClick = closeAction,
  )
  val iconData: IconData = IconData.Standard(
    iconResId = iconRes,
    iconSize = IconSize.SIZE64,
    iconColorProvider = iconColorProvider,
    contentDescription = iconContentDescription,
  )
}
