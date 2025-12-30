/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.textinput

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.domain.label.toLabel
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.textinput.model.TextInputData
import pl.gov.coi.common.ui.focus.FocusHost
import pl.gov.coi.common.ui.focus.createFocusHost
import pl.gov.coi.common.ui.theme.AppTheme

private val COUNTRY_CODE_MIN_WIDTH = 70.dp
private val COUNTRY_CODE_MAX_WIDTH = 110.dp

@Composable
internal fun TextFieldPhoneNumber(
  data: TextInputData.PhoneNumber,
  focusHost: FocusHost,
  focusManager: FocusManager,
) {
  Row {
    Box(modifier = Modifier.widthIn(min = COUNTRY_CODE_MIN_WIDTH, max = COUNTRY_CODE_MAX_WIDTH)) {
      TextField(
        data = data.countryCodeNumber,
        focusHost = focusHost,
        focusManager = focusManager,
      )
    }

    Spacer(modifier = Modifier.width(width = AppTheme.dimensions.spacing100))
    Box(modifier = Modifier) {
      TextField(
        data = data.phoneNumber,
        focusHost = focusHost,
        focusManager = focusManager,
      )
    }
  }
}

@Preview
@Composable
fun Preview() {
  TextFieldPhoneNumber(
    data = TextInputData.PhoneNumber(
      label = "Numer telefonu".toLabel(tag = "phoneNumberPreviewLabel"),
      countryCodeValue = "+48".toLabel(tag = "countryCodePreviewValue"),
      phoneNumberValue = "123456789".toLabel(tag = "phoneNumberPreviewValue"),
      onCountryCodeChanged = {},
      onPhoneNumberChanged = {},
      isCountryCodeCorrect = null,
      isPhoneNumberCorrect = null,
      validationState = ValidationState.Default,
    ),
    focusHost = createFocusHost(),
    focusManager = LocalFocusManager.current,
  )
}
