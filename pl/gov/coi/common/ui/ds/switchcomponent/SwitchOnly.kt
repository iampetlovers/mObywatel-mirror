/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.switchcomponent

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.semanticsContentDescription

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun SwitchOnly(
  data: SwitchData.SwitchOnly,
) {
  Box(
    contentAlignment = Alignment.Center,
  ) {
    Switch(
      modifier = Modifier
        .semanticsContentDescription(data.contentDescription?.text ?: "")
        .semantics { testTagsAsResourceId = true }
        .semantics { testTag = data.testTag ?: "switch${data.testIndexTag?.let { "_${data.testIndexTag}" } ?: ""}" },
      checked = data.checked,
      enabled = data.enabled,
      colors = SwitchDefaults.colors(
        checkedThumbColor = AppTheme.colors.white,
        checkedTrackColor = AppTheme.colors.primary900,
        uncheckedThumbColor = AppTheme.colors.neutral80,
        uncheckedTrackColor = AppTheme.colors.neutral10,
        uncheckedBorderColor = AppTheme.colors.neutral80,
        disabledCheckedThumbColor = AppTheme.colors.white,
        disabledCheckedTrackColor = AppTheme.colors.neutral10,
        disabledUncheckedThumbColor = AppTheme.colors.neutral60,
        disabledUncheckedTrackColor = AppTheme.colors.neutral10,
        disabledUncheckedBorderColor = AppTheme.colors.neutral30,
      ),
      onCheckedChange = data.onCheckedChange,
    )
  }
}
