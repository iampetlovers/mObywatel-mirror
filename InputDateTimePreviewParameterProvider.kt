/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.inputdatetime

import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.R

data class InputDateTimeData(
  val label: Label,
  val inputText: String? = null,
  val type: Type,
  val validationState: ValidationState = ValidationState.Default,
  val helperText: Label? = null,
  val enabled: Boolean = true,
  val onClick: () -> Unit,
) {

  sealed class Type(
    val iconResId: Int,
    val placeholder: String,
  ) {
    data object Time : Type(
      iconResId = R.drawable.aa016_history,
      placeholder = TIME_PLACEHOLDER,
    )

    data object Date : Type(
      iconResId = R.drawable.aa007_date_picker,
      placeholder = DATE_PLACEHOLDER,
    )
  }

  companion object {
    private const val DATE_PLACEHOLDER = "DD.MM.RRRR"
    private const val TIME_PLACEHOLDER = "GG:MM"
  }
}
