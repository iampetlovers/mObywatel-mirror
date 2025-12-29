/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.chatbubble

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.ui.theme.AppTheme

const val DELAY_UNIT = 300

@Composable
internal fun DotsTyping() {
  val maxOffset = 10f

  @Composable
  fun Dot(
    offset: Float,
    color: Color,
  ) = Spacer(
    modifier = Modifier
      .size(AppTheme.dimensions.spacing100)
      .offset(y = -offset.dp)
      .background(
        color = color,
        shape = CircleShape,
      ),
  )

  val infiniteTransition = rememberInfiniteTransition()

  @Composable
  fun animateOffsetWithDelay(delay: Int) = infiniteTransition.animateFloat(
    initialValue = 0f,
    targetValue = 0f,
    animationSpec = infiniteRepeatable(
      animation = keyframes {
        durationMillis = DELAY_UNIT * 4
        0f at delay with LinearEasing
        maxOffset at delay + DELAY_UNIT with LinearEasing
        0f at delay + DELAY_UNIT * 2
      },
    ),
  )

  val firstDotAnimationOffset by animateOffsetWithDelay(0)
  val secondDotAnimationOffset by animateOffsetWithDelay(DELAY_UNIT)
  val thirdDotAnimationOffset by animateOffsetWithDelay(DELAY_UNIT * 2)

  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center,
    modifier = Modifier.padding(top = maxOffset.dp),
  ) {
    Dot(offset = firstDotAnimationOffset, color = AppTheme.colors.neutral200.copy(alpha = 0.25F))
    Spacer(Modifier.width(AppTheme.dimensions.spacing50))
    Dot(offset = secondDotAnimationOffset, color = AppTheme.colors.neutral200.copy(alpha = 0.5F))
    Spacer(Modifier.width(AppTheme.dimensions.spacing50))
    Dot(offset = thirdDotAnimationOffset, color = AppTheme.colors.neutral200)
  }
}
