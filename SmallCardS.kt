/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.smallcards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.domain.label.Label
import pl.gov.coi.common.ui.ds.custom.icon.BackgroundShape
import pl.gov.coi.common.ui.ds.custom.icon.Icon
import pl.gov.coi.common.ui.ds.custom.icon.IconData
import pl.gov.coi.common.ui.ds.custom.icon.IconSize
import pl.gov.coi.common.ui.ds.smallcards.provider.SmallCardSPPP
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import pl.gov.coi.common.ui.utils.NoRippleInteractionSource

private val componentWidth = 80.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SmallCardS(
  smallCardSData: SmallCardSData,
) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .width(componentWidth)
      .semantics { testTagsAsResourceId = true }
      .semantics { testTag = smallCardSData.testTag ?: smallCardSData.title.tag }
      .clickable(
        interactionSource = NoRippleInteractionSource(),
        indication = null,
        role = Role.Button,
        onClick = smallCardSData.onClick,
      ),
  ) {
    Icon(
      data = IconData.Background(
        testTag = smallCardSData.testTag?.let { tag -> tag + "Icon" },
        iconResId = smallCardSData.iconResId,
        backgroundSize = IconSize.SIZE48,
        iconSize = IconSize.SIZE24,
        iconColorProvider = smallCardSData.iconColorProvider,
        backgroundColorProvider = { AppTheme.colors.white },
        backgroundShape = BackgroundShape.Rounded,
        contentDescription = Label.EMPTY,
      ),
    )
    Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing100))
    CustomText(
      testTag = smallCardSData.testTag?.let { tag -> tag + "Text" },
      label = smallCardSData.title,
      style = AppTheme.typography.bodySmallRegular,
      color = AppTheme.colors.neutral500,
      textAlign = TextAlign.Center,
      labelContentDescription = smallCardSData.title,
      focusable = false,
      maxLines = 3,
    )
  }
}

@Preview(showBackground = true)
@Composable
fun SmallCardSPreview(@PreviewParameter(SmallCardSPPP::class) data: SmallCardSData) {
  SmallCardS(data)
}
