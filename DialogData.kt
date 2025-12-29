/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.dialog

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.button.ButtonData

sealed class DialogData(
  open val testTag: String?,
  open val title: Label,
  open val body: Label? = null,
  open val annotatedBody: (@Composable () -> AnnotatedString)? = null,
  open val primaryButtonData: ButtonData,
  open val secondaryButtonData: ButtonData? = null,
  internal val horizontalAlignment: Alignment.Horizontal = Alignment.Start,
  internal val textAlign: TextAlign = TextAlign.Start,
  open val onDismiss: () -> Unit,
) {
  data class WithThreeButtons(
    override val testTag: String? = null,
    override val title: Label,
    override val body: Label? = null,
    override val annotatedBody: (@Composable () -> AnnotatedString)? = null,
    override val primaryButtonData: ButtonData,
    override val secondaryButtonData: ButtonData,
    val tertiaryButtonData: ButtonData,
    override val onDismiss: () -> Unit,
  ) : DialogData(
    testTag = testTag,
    title = title,
    body = body,
    annotatedBody = annotatedBody,
    primaryButtonData = primaryButtonData,
    secondaryButtonData = secondaryButtonData,
    onDismiss = onDismiss,
    horizontalAlignment = Alignment.Start,
    textAlign = TextAlign.Start,
  )

  data class WithText(
    override val testTag: String? = null,
    override val title: Label,
    override val body: Label? = null,
    override val annotatedBody: (@Composable () -> AnnotatedString)? = null,
    override val primaryButtonData: ButtonData,
    override val secondaryButtonData: ButtonData? = null,
    override val onDismiss: () -> Unit,
  ) : DialogData(
    testTag = testTag,
    title = title,
    body = body,
    annotatedBody = annotatedBody,
    primaryButtonData = primaryButtonData,
    secondaryButtonData = secondaryButtonData,
    onDismiss = onDismiss,
    horizontalAlignment = Alignment.Start,
    textAlign = TextAlign.Start,
  )

  data class WithIcon(
    override val testTag: String? = null,
    override val title: Label,
    override val body: Label? = null,
    override val annotatedBody: (@Composable () -> AnnotatedString)? = null,
    override val primaryButtonData: ButtonData,
    override val secondaryButtonData: ButtonData? = null,
    val icon: DialogIconData,
    override val onDismiss: () -> Unit,
  ) : DialogData(
    testTag = testTag,
    title = title,
    body = body,
    annotatedBody = annotatedBody,
    primaryButtonData = primaryButtonData,
    secondaryButtonData = secondaryButtonData,
    onDismiss = onDismiss,
    horizontalAlignment = Alignment.CenterHorizontally,
    textAlign = TextAlign.Center,
  )
}

data class DialogIconData(
  @DrawableRes val iconResId: Int,
  val iconColorProvider: @Composable () -> Color,
)
