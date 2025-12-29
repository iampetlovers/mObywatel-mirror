/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.snackbar

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.theme.AppTheme

sealed class SnackBarData(
  open val messageLabel: Label,
  descriptionLabel: Label? = null,
  override val duration: SnackbarDuration = SnackbarDuration.Short,
) : SnackbarVisuals {
  override val actionLabel: String? = descriptionLabel?.text

  data class Default(
    override val messageLabel: Label,
    override val withDismissAction: Boolean = false,
    override val message: String = messageLabel.text,
  ) : SnackBarData(messageLabel = messageLabel)

  data class DefaultWithIcon(
    override val messageLabel: Label,
    override val withDismissAction: Boolean = true,
    override val message: String = messageLabel.text,
    val onAction: () -> Unit = {},
  ) : SnackBarData(messageLabel = messageLabel) {
    internal val iconButtonData = ButtonIconData(
      iconResId = R.drawable.ab009_x_mark,
      iconColorProvider = { AppTheme.colors.white },
      contentDescription = CommonUILabelProvider.closeLabel(),
      onClick = onAction,
    )
  }
}
