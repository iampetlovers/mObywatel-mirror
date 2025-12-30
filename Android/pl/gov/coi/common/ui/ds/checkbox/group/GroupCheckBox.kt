/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.checkbox.group

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.R
import pl.gov.coi.common.ui.ds.checkbox.common.CheckBoxBottomText
import pl.gov.coi.common.ui.ds.checkbox.common.CheckboxRow
import pl.gov.coi.common.ui.ds.checkbox.common.model.CheckboxContentType
import pl.gov.coi.common.ui.ds.checkbox.group.model.CheckBoxGroupData
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIcon
import pl.gov.coi.common.ui.ds.button.buttonicon.ButtonIconData
import pl.gov.coi.common.ui.ds.contentbox.ContentBox
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun CheckBoxGroup(data: CheckBoxGroupData) {
  Column {
    data.header?.let { header ->
      LabelRow(
        label = header.label,
        onHelperButtonClick = header.onClick,
      )
    }
    when (data.contentType) {
      CheckboxContentType.CONTENT_BOX -> ContentBox {
        GroupCheckBoxContainerContent(data)
      }

      CheckboxContentType.DEFAULT -> GroupCheckBoxContainerContent(data)
    }
  }
}

@Composable
private fun GroupCheckBoxContainerContent(data: CheckBoxGroupData) {
  Column {
    data.checkboxes.forEachIndexed { index, checkboxData ->
      CheckboxRow(data = checkboxData, type = data.type, isEnabled = data.isEnabled)
      if (index != data.checkboxes.lastIndex) {
        Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing250))
      }
    }
    CheckBoxBottomText(data.type)
  }
}

@Composable
private fun ColumnScope.LabelRow(label: Label, onHelperButtonClick: (() -> Unit)?) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    CustomText(
      textAlign = TextAlign.Start,
      label = label,
      style = AppTheme.typography.subtitleMedium,
      color = AppTheme.colors.neutral500,
    )
    onHelperButtonClick?.let { onClick ->
      Spacer(modifier = Modifier.width(AppTheme.dimensions.spacing50))
      ButtonIcon(
        data = ButtonIconData(
          iconResId = R.drawable.ab015_help,
          onClick = onClick,
          iconColorProvider = { AppTheme.colors.primary900 },
        ),
      )
    }
  }
  Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing200))
}

@Composable
@Preview
fun GroupCheckBoxPreview(@PreviewParameter(GroupCheckBoxPPP::class) data: CheckBoxGroupData) {
  Box(
    modifier = Modifier
      .background(AppTheme.colors.background)
      .padding(AppTheme.dimensions.spacing200)
      .fillMaxSize(),
  ) {
    CheckBoxGroup(data)
  }
}
