/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.singlecard.radiobutton

import androidx.compose.foundation.layout.size
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.theme.AppTheme

@Deprecated(
  message = "Do not use.",
  replaceWith = ReplaceWith("pl.gov.coi.common.ui.ds.radiobutton.RadioButton"),
)
@Composable
fun OldRadioButton(
  data: OldRadioButtonData,
) {
  RadioButton(
    modifier = Modifier.size(size = AppTheme.dimensions.spacing300),
    selected = data.isSelected,
    onClick = null,
    enabled = data.enabled,
    colors = RadioButtonDefaults.colors(
      selectedColor = AppTheme.colors.primary900,
      unselectedColor = AppTheme.colors.neutral80.orRedIfInvalid(
        validationState = data.validationState,
      ),
      disabledColor = AppTheme.colors.neutral30,
    ),
  )
}

@Composable
fun Color.orRedIfInvalid(validationState: ValidationState) =
  if (validationState is ValidationState.Invalid) {
    AppTheme.colors.supportRed100
  } else {
    this
  }
