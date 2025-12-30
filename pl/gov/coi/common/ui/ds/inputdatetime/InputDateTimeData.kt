/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.inputdatetime

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.domain.validators.ValidationState
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.errortext.ErrorText
import pl.gov.coi.common.ui.ds.helpertext.HelperText
import pl.gov.coi.common.ui.ds.inputdatetime.provider.InputDateTimePreviewParameterProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.MultipleEventsCutter
import pl.gov.coi.common.ui.utils.get

@Composable
fun InputDateTime(
  data: InputDateTimeData,
) {
  val multipleEventsCutter = remember { MultipleEventsCutter.get() }

  Column(
    modifier = Modifier
      .semantics { isTraversalGroup = true }
      .fillMaxWidth()
      .wrapContentHeight(),
  ) {
    CustomText(
      label = data.label,
      style = AppTheme.typography.bodyMediumRegular,
      color = if (data.enabled) {
        AppTheme.colors.neutral200
      } else {
        AppTheme.colors.neutral60
      },
    )
    Card(
      modifier = Modifier
        .padding(vertical = AppTheme.dimensions.spacing50)
        .semantics {
          if (data.enabled.not()) disabled()
          testTag = data.label.text + "Value"
        }
        .clickable(
          enabled = data.enabled,
          onClick = {
            multipleEventsCutter.processEvent {
              data.onClick()
            }
          },
        ),
      border = BorderStroke(
        width = AppTheme.dimensions.strokeWidth,
        color = when {
          data.validationState is ValidationState.Invalid -> AppTheme.colors.supportRed100
          data.enabled.not() -> AppTheme.colors.neutral30
          else -> AppTheme.colors.neutral80
        },
      ),
      shape = AppTheme.shapes.radius50,
      elevation = CardDefaults.cardElevation(defaultElevation = AppTheme.elevations.level0),
    ) {
      Row(
        modifier = Modifier
          .background(color = Color.White)
          .padding(all = AppTheme.dimensions.spacing200)
          .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(space = AppTheme.dimensions.spacing100),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Text(
          modifier = Modifier.weight(weight = 1f),
          text = data.inputText?.takeIf { it.isNotBlank() } ?: data.type.placeholder,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          style = AppTheme.typography.bodyLargeRegular,
          color = when {
            data.enabled.not() -> AppTheme.colors.neutral60
            data.inputText.isNullOrBlank() -> AppTheme.colors.neutral100
            else -> AppTheme.colors.neutral500
          },
        )
        Icon(
          data = IconData.Standard(
            iconResId = data.type.iconResId,
            iconSize = IconSize.SIZE24,
            iconColorProvider = {
              if (data.enabled) {
                AppTheme.colors.neutral200
              } else {
                AppTheme.colors.neutral60
              }
            },
            contentDescription = null,
          ),
        )
      }
    }
    if (data.validationState is ValidationState.Invalid) {
      ErrorText(errorText = data.validationState.message)
    } else {
      data.helperText?.let { text ->
        HelperText(helperLabel = text)
      }
    }
  }
}

@Preview
@Composable
fun InputDateTimePreview(
  @PreviewParameter(InputDateTimePreviewParameterProvider::class)
  data: InputDateTimeData,
) {
  Box(modifier = Modifier.background(color = AppTheme.colors.white)) {
    InputDateTime(data = data)
  }
}
