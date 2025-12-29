/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.preview.WrappedValue
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonItemData
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource

@Composable
fun RadioButtonItem(
  data: RadioButtonItemData,
) {
  RadioButton(
    selected = data.isSelected,
    enabled = data.enabled,
    interactionSource = NoRippleInteractionSource(),
    colors = RadioButtonDefaults.colors(
      selectedColor = AppTheme.colors.primary900.orRedIfError(
        isError = data.isError,
      ),
      unselectedColor = AppTheme.colors.neutral80.orRedIfError(
        isError = data.isError,
      ),
      disabledSelectedColor = AppTheme.colors.neutral30,
      disabledUnselectedColor = AppTheme.colors.neutral30,
    ),
    onClick = null,
  )
}

@Composable
private fun Color.orRedIfError(isError: Boolean) =
  if (isError) {
    AppTheme.colors.supportRed100
  } else {
    this
  }

@Preview
@Composable
fun RadioButtonItemPreview(
  @PreviewParameter(RadioButtonItemPPP::class)
  wrappedValue: WrappedValue<RadioButtonItemData>,
) {
  Column(
    modifier = Modifier
      .background(color = AppTheme.colors.background)
      .fillMaxSize()
      .padding(all = AppTheme.dimensions.spacing200),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    RadioButtonItem(data = wrappedValue.value())
  }
}
