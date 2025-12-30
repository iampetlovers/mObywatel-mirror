/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.custom.documentrow

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.custom.documentrow.provider.ProvidedSingleCardDocumentRowData
import pl.gov.coi.common.ui.ds.custom.documentrow.provider.SingleCardDocumentRowPPP
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.singlecard.SINGLE_CARD_MINIMUM_HEIGHT
import pl.gov.coi.common.ui.ds.statusbadge.StatusBadge
import pl.gov.coi.common.ui.preview.WrappedValue
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.MultipleEventsCutter
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource
import pl.gov.coi.common.ui.utils.get

@Composable
fun SingleCardDocumentRow(data: DocumentRowData) {
  val multipleEventsCutter = remember { MultipleEventsCutter.get() }

  Card(
    modifier = Modifier.semantics { testTag = data.testTag ?: data.title.tag },
    colors = CardDefaults.cardColors(containerColor = AppTheme.colors.white),
    interactionSource = NoRippleInteractionSource(),
    onClick = { multipleEventsCutter.processEvent { data.onClick() } },
    shape = RoundedCornerShape(AppTheme.dimensions.spacing200),
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .defaultMinSize(minHeight = SINGLE_CARD_MINIMUM_HEIGHT)
        .fillMaxWidth()
        .padding(all = AppTheme.dimensions.spacing250),
    ) {
      SingleCardClickableContent(data = data)

      Icon(
        modifier = Modifier.padding(start = AppTheme.dimensions.spacing200),
        data = data.trailingIcon,
      )
    }
  }
}

@Composable
private fun RowScope.SingleCardClickableContent(
  data: DocumentRowData,
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
    Column(
      verticalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing50),
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f),
    ) {
      CustomText(
        testTag = data.testTag?.let { tag -> tag + "TitleText" },
        label = data.title,
        style = AppTheme.typography.bodyLargeMedium,
        modifier = Modifier.fillMaxWidth(),
      )
      data.description?.let { description ->
        CustomText(
          testTag = data.testTag?.let { tag -> tag + "DescriptionText" },
          label = description,
          style = AppTheme.typography.bodyMediumRegular,
          modifier = Modifier.fillMaxWidth(),
        )
      }

      data.badgeData?.let { badge ->
        Spacer(modifier = Modifier.height(height = AppTheme.dimensions.spacing25))
        StatusBadge(data = badge)
      }
    }
  }
}

@Preview
@Composable
fun SingleCardDocumentRowPreview(
  @PreviewParameter(SingleCardDocumentRowPPP::class)
  wrappedValue: WrappedValue<ProvidedSingleCardDocumentRowData>,
) = with(wrappedValue.value()) {
  Column {
    Text(
      modifier = Modifier.padding(AppTheme.dimensions.spacing250),
      text = previewName,
    )
    SingleCardDocumentRow(data = data)
  }
}
