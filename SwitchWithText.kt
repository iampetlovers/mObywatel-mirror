/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.switchcomponent

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.launch
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.errortext.ErrorText
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun SwitchWithText(
  data: SwitchData.SwitchWithText,
) {
  val bringIntoViewRequester = remember { BringIntoViewRequester() }
  var inputFieldCoordinates by remember { mutableStateOf(IntOffset(0, 0)) }
  val coroutineScope = rememberCoroutineScope()
  var validationMessageShowed by remember { mutableStateOf(false) }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .bringIntoViewRequester(bringIntoViewRequester = bringIntoViewRequester)
      .toggleable(
        role = Role.Switch,
        value = data.checked,
        enabled = false,
        onValueChange = { value -> data.onCheckedChange?.invoke(value) },
      )
      .onGloballyPositioned { coordinates ->
        inputFieldCoordinates = IntOffset(
          x = coordinates.positionInWindow().x.toInt(),
          y = coordinates.positionInWindow().y.toInt(),
        )
        if ((data.validationState is ValidationState.Invalid) && !validationMessageShowed) {
          coroutineScope.launch {
            bringIntoViewRequester.bringIntoView()
            validationMessageShowed = true
          }
        }
      },
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.Start,
      verticalAlignment = Alignment.CenterVertically,
    ) {
      CustomText(
        testTag = data.testTag?.let { tag -> tag + "Text" },
        modifier = Modifier
          .weight(1f),
        label = data.label,
        style = AppTheme.typography.bodyMediumRegular,
        color = AppTheme.colors.neutral200,
      )
      Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing100))
      SwitchOnly(
        data = SwitchData.SwitchOnly(
          testTag = data.testTag?.let { tag -> tag + "Switch" },
          checked = data.checked,
          enabled = data.enabled,
          onCheckedChange = data.onCheckedChange,
          contentDescription = data.label,
          testIndexTag = data.testIndexTag,
        ),
      )
    }
    if (data.validationState is ValidationState.Invalid) {
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
      ErrorText(testTag = data.testTag?.let { tag -> tag + "ErrorText" }, errorText = data.validationState.message)
    }
  }
}
