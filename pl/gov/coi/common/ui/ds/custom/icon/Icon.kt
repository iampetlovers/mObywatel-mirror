/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.custom.icon

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.custom.icon.provider.IconPreviewParameterProvider
import pl.gov.coi.common.ui.utils.getResourceEntryNameIcon
import pl.gov.coi.common.ui.utils.semanticsContentDescription

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Icon(
  modifier: Modifier = Modifier,
  data: IconData,
  focusable: Boolean? = null,
) {
  val localContext = LocalContext.current
  Box(
    modifier = modifier
      .alpha(data.iconState.alphaValue)
      .semantics { testTagsAsResourceId = true }
      .semantics { testTag = data.testTag ?: "icon${getResourceEntryNameIcon(data.iconResId, localContext)}" }
      .semanticsContentDescription(data.contentDescription?.text, focusable),
    contentAlignment = Alignment.Center,
  ) {
    if (data is IconData.Background) {
      val backgroundColor = data.backgroundColorProvider()
      Canvas(
        modifier = Modifier
          .size(data.backgroundSize.dimension)
          .then(
            if (data.backgroundShape is BackgroundShape.RoundedSquare) {
              Modifier.clip(data.backgroundShape.shape())
            } else {
              Modifier
            },
          ),
        onDraw = {
          when (data.backgroundShape) {
            BackgroundShape.Rounded ->
              drawCircle(color = backgroundColor)

            BackgroundShape.Square,
            is BackgroundShape.RoundedSquare,
            ->
              drawRoundRect(
                color = backgroundColor,
              )
          }
        },
      )
    }

    androidx.compose.material.Icon(
      modifier = Modifier
        .size(data.iconSize.dimension),
      painter = painterResource(id = data.iconResId),
      contentDescription = null,
      tint = data.iconColorProvider(),
    )
  }
}

@Preview
@Composable
fun IconPreview(@PreviewParameter(IconPreviewParameterProvider::class) data: IconData) {
  Icon(data = data)
}
