/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.textarea

import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.ImeAction
import pl.gov.coi.common.domain.label.Label

private const val DEFAULT_MIN_LINES = 4

data class TextAreaData(
  val testTag: String? = null,
  val label: Label? = null,
  val type: TextAreaType,
  val indexTag: Int? = null,
  val state: TextAreaDataState,
  val content: String = "",
  val enabled: Boolean = true,
  val counterState: CounterState,
  val hint: Label = Label.EMPTY,
  val imeAction: ImeAction = ImeAction.Done,
  val focusRequester: FocusRequester? = null,
  val onValueChanged: (String) -> Unit,
)

sealed interface CounterState {
  data object Hidden : CounterState
  data class Visible(
    val maxLength: Int,
    val onCharsLimitReached: (Boolean) -> Unit = {},
  ) : CounterState
}

sealed interface TextAreaType {
  data class Fix(
    val lines: Int = DEFAULT_MIN_LINES,
  ) : TextAreaType

  data class Flexible(
    val maxLines: Int = Integer.MAX_VALUE,
  ) : TextAreaType
}

sealed interface TextAreaDataState {
  data class Error(val errorLabel: Label) : TextAreaDataState
  data class Default(val helperLabel: Label = Label.EMPTY) : TextAreaDataState
}
