/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonrow

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import pl.gov.coi.common.ui.ds.radiobutton.common.model.RadioButtonRow
import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttoncontent.RadioButtonContent
import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttondescription.RadioButtonDescription
import pl.gov.coi.common.ui.ds.radiobutton.common.radiobuttonitem.RadioButtonItem
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.MultipleEventsCutter
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
import pl.gov.coi.common.ui.utils.get

@Composable
internal fun RadioButtonRow(
  data: RadioButtonRow,
) {
  val multipleEventsCutter = remember { MultipleEventsCutter.get() }
  Row(
    modifier = Modifier
      .wrapContentHeight()
      .semantics {
        testTag = "radiobutton ${data.label.tag}"
      }
      .selectable(
        selected = data.item.isSelected,
        role = Role.RadioButton,
        enabled = data.item.enabled,
        interactionSource = NoRippleInteractionSource(),
        indication = null,
        onClick = {
          if (data.item.enabled && data.item.isSelected.not()) {
            multipleEventsCutter.processEvent {
              data.onClick()
            }
          }
        },
      ),
  ) {
    RadioButtonItem(data = data.item)
    Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing200))
    Column(modifier = Modifier.fillMaxWidth()) {
      CustomText(
        label = data.label,
        style = AppTheme.typography.bodyLargeRegular,
        color = AppTheme.colors.neutral500,
      )
      RadioButtonDescription(
        description = data.description,
      )
      RadioButtonContent(
        content = data.content?.content(),
        isSelected = data.item.isSelected,
      )
    }
  }
}
