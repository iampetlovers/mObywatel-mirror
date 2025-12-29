/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.custom.icon

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.domain.label.Label

sealed class IconData(
  internal val testTag: String?,
  @DrawableRes internal val iconResId: Int,
  internal val iconSize: IconSize,
  internal val iconColorProvider: @Composable () -> Color,
  internal val contentDescription: Label?,
  internal val iconState: IconState,
) {
  class Standard(
    testTag: String? = null,
    iconResId: Int,
    iconSize: IconSize,
    iconColorProvider: @Composable () -> Color,
    contentDescription: Label?,
    iconState: IconState = IconState.ENABLED,
  ) : IconData(
    testTag = testTag,
    iconResId = iconResId,
    iconSize = iconSize,
    iconColorProvider = iconColorProvider,
    contentDescription = contentDescription,
    iconState = iconState,
  )

  class Background(
    testTag: String? = null,
    iconResId: Int,
    iconSize: IconSize,
    iconColorProvider: @Composable () -> Color,
    internal val backgroundSize: IconSize,
    internal val backgroundColorProvider: @Composable () -> Color,
    internal val backgroundShape: BackgroundShape,
    contentDescription: Label?,
    iconState: IconState = IconState.ENABLED,
  ) : IconData(
    testTag = testTag,
    iconResId = iconResId,
    iconSize = iconSize,
    iconColorProvider = iconColorProvider,
    contentDescription = contentDescription,
    iconState = iconState,
  )
}

val IconData.contentDescriptionTextOrEmpty
  get() = contentDescription?.text.orEmpty()

enum class IconSize(internal val dimension: Dp) {
  SIZE2(dimension = 2.dp),
  SIZE4(dimension = 4.dp),
  SIZE6(dimension = 6.dp),
  SIZE8(dimension = 8.dp),
  SIZE12(dimension = 12.dp),
  SIZE14(dimension = 14.dp),
  SIZE16(dimension = 16.dp),
  SIZE20(dimension = 20.dp),
  SIZE24(dimension = 24.dp),
  SIZE30(dimension = 30.dp),
  SIZE32(dimension = 32.dp),
  SIZE40(dimension = 40.dp),
  SIZE48(dimension = 48.dp),
  SIZE56(dimension = 56.dp),
  SIZE64(dimension = 64.dp),
  SIZE72(dimension = 72.dp),
  SIZE96(dimension = 96.dp),
}

sealed interface BackgroundShape {
  object Rounded : BackgroundShape
  object Square : BackgroundShape
  class RoundedSquare(
    val shape: @Composable () -> Shape,
  ) : BackgroundShape
}

enum class IconState(val alphaValue: Float) {
  ENABLED(alphaValue = 1f),
  DISABLED(alphaValue = 0.3f),
}
