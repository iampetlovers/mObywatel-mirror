/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.progressbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import pl.gov.coi.common.ui.ds.progressbar.provider.ProgressBarPreviewParameterProvider
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme

@Composable
fun ProgressBar(
  data: ProgressBarData,
) {
  val progress = remember { (data.value.toDouble() / PERCENTAGE).toFloat() }
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .semantics { testTag = data.testTag ?: "Progress" },
  ) {
    if (data is ProgressBarData.IndicatorBar) {
      CustomText(
        modifier = Modifier
          .fillMaxWidth(progress),
        testTag = data.testTag?.let { tag -> tag + "Text" },
        label = data.label,
        style = AppTheme.typography.bodySmallRegular,
        color = AppTheme.colors.neutral200,
        textAlign = TextAlign.End,
      )
      Spacer(modifier = Modifier.height(AppTheme.dimensions.spacing50))
    }
    LinearProgressIndicator(
      progress = progress,
      modifier = Modifier
        .fillMaxWidth(),
      color = AppTheme.colors.primary900,
      backgroundColor = AppTheme.colors.neutral30,
      strokeCap = StrokeCap.Round,
    )
  }
}

@Composable
@Preview
fun ProgressBarPreview(
  @PreviewParameter(ProgressBarPreviewParameterProvider::class)
  progressBarData: ProgressBarData,
) {
  Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier
      .fillMaxSize()
      .background(AppTheme.colors.background),
  ) {
    Column(modifier = Modifier.padding(AppTheme.dimensions.spacing250)) {
      ProgressBar(data = progressBarData)
    }
  }
}

private const val PERCENTAGE = 100.00
