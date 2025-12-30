/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package pl.gov.coi.common.ui.ds.singlecard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import pl.gov.coi.common.ui.ds.checkbox.single.CheckBoxSingle
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource

@Composable
internal fun SingleCardSelectableCheckbox(
  data: SingleCardData.SelectableCheckbox,
) {
  Card(
    modifier = Modifier.semantics { testTag = data.testTag ?: data.title.tag },
    enabled = data.checkboxData.isEnabled,
    colors = CardDefaults.cardColors(
      containerColor = AppTheme.colors.white,
      disabledContainerColor = AppTheme.colors.neutral30,
    ),
    border = when {
      data.checkboxData.checkbox.isChecked -> BorderStroke(
        width = AppTheme.dimensions.strokeWidth,
        color = AppTheme.colors.primary900,
      )
      else -> null
    },
    interactionSource = NoRippleInteractionSource(),
    onClick = { },
    shape = RoundedCornerShape(AppTheme.dimensions.spacing200),
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .defaultMinSize(minHeight = SINGLE_CARD_MINIMUM_HEIGHT)
        .fillMaxWidth()
        .padding(all = AppTheme.dimensions.spacing250),
    ) {
      when (data) {
        is SingleCardData.SelectableCheckbox.Title -> SingleCardSelectableCheckboxTitleContent(data = data)
        is SingleCardData.SelectableCheckbox.IconTitle -> SingleCardSelectableCheckboxIconTitleContent(data = data)
        is SingleCardData.SelectableCheckbox.TitleDescription ->
          SingleCardSelectableCheckboxTitleDescriptionContent(data = data)
      }
      Spacer(
        modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
      )
      CheckBoxSingle(data = data.checkboxData)
    }
  }
}

@Composable
internal fun RowScope.SingleCardSelectableCheckboxTitleContent(
  data: SingleCardData.SelectableCheckbox.Title,
) {
  CustomText(
    label = data.title,
    style = AppTheme.typography.bodyLargeMedium,
    modifier = Modifier.weight(1f),
  )
}

@Composable
internal fun RowScope.SingleCardSelectableCheckboxTitleDescriptionContent(
  data: SingleCardData.SelectableCheckbox.TitleDescription,
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .weight(1f),
  ) {
    CustomText(
      label = data.title,
      style = AppTheme.typography.bodyLargeMedium,
      modifier = Modifier.fillMaxWidth(),
    )
    Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing100))
    CustomText(
      label = data.description,
      style = AppTheme.typography.bodyMediumRegular,
      color = AppTheme.colors.neutral200,
      modifier = Modifier.fillMaxWidth(),
    )
    data.descriptionSecond?.let { descriptionSecond ->
      Spacer(
        modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
      )
      CustomText(
        label = descriptionSecond,
        style = AppTheme.typography.bodyMediumRegular,
        color = AppTheme.colors.neutral200,
        modifier = Modifier.fillMaxWidth(),
      )
    }
    data.descriptionThird?.let { descriptionThird ->
      Spacer(
        modifier = Modifier.height(height = AppTheme.dimensions.spacing100),
      )
      CustomText(
        label = descriptionThird,
        style = AppTheme.typography.bodyMediumRegular,
        color = AppTheme.colors.neutral200,
        modifier = Modifier.fillMaxWidth(),
      )
    }
  }
}

@Composable
internal fun RowScope.SingleCardSelectableCheckboxIconTitleContent(
  data: SingleCardData.SelectableCheckbox.IconTitle,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .fillMaxWidth()
      .weight(1f),
  ) {
    Icon(
      data = data.iconData,
    )
    Spacer(
      modifier = Modifier.width(width = AppTheme.dimensions.spacing200),
    )
    CustomText(
      label = data.title,
      style = AppTheme.typography.bodyLargeMedium,
      modifier = Modifier.fillMaxWidth(),
    )
  }
}
