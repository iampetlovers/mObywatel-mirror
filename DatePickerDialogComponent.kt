/*
Copyright (c) 2025 Centralny Ośrodek Informatyki

Niniejszym udziela się każdej osobie, która uzyska kopię tego oprogramowania i powiązanej dokumentacji (dalej „Oprogramowanie”), bezpłatnie, prawa do korzystania z Oprogramowania bez ograniczeń, w tym bez ograniczeń prawa do używania, kopiowania, modyfikowania, łączenia, publikowania, dystrybuowania, sublicencjonowania i/lub sprzedaży kopii Oprogramowania, a także do zezwalania osobom, którym Oprogramowanie jest dostarczane, na to samo, z zastrzeżeniem następujących warunków:
Powyższa informacja o prawach autorskich oraz niniejsza zgoda muszą być dołączone do wszystkich kopii lub istotnych części Oprogramowania.
OPROGRAMOWANIE JEST DOSTARCZANE „TAK JAK JEST”, BEZ JAKIEJKOLWIEK GWARANCJI, WYRAŹNEJ LUB DOROZUMIANEJ, W TYM MIĘDZY INNYMI GWARANCJI PRZYDATNOŚCI HANDLOWEJ, PRZYDATNOŚCI DO OKREŚLONEGO CELU ORAZ NIENARUSZANIA PRAW. W ŻADNYM WYPADKU AUTORZY LUB POSIADACZE PRAW AUTORSKICH NIE PONOSZĄ ODPOWIEDZIALNOŚCI ZA JAKIEKOLWIEK ROSZCZENIA, SZKODY LUB INNE ZOBOWIĄZANIA, CZY TO W WYNIKU UMOWY, CZYNÓW NIEDOZWOLONYCH, CZY W INNY SPOSÓB, WYNIKAJĄCE Z OPROGRAMOWANIA LUB KORZYSTANIA Z NIEGO LUB INNYCH DZIAŁAŃ ZWIĄZANYCH Z OPROGRAMOWANIEM.
*/

package pl.gov.coi.common.ui.ds.datepicker

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pl.gov.coi.common.domain.label.CommonUILabelProvider
import pl.gov.coi.common.ui.ds.button.Button
import pl.gov.coi.common.ui.ds.button.ButtonData
import pl.gov.coi.common.ui.ds.button.common.ButtonSize
import pl.gov.coi.common.ui.ds.button.common.ButtonType
import pl.gov.coi.common.ui.ds.button.common.ButtonVariant
import pl.gov.coi.common.ui.text.CustomText
import pl.gov.coi.common.ui.theme.AppTheme
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialogComponent(
  data: DatePickerDialogData,
) {
  val customSpacing: Dp = 6.dp

  val datePickerColors = DatePickerDefaults.colors(
    containerColor = AppTheme.colors.white,
    titleContentColor = AppTheme.colors.neutral200,
    headlineContentColor = AppTheme.colors.neutral500,
    weekdayContentColor = AppTheme.colors.neutral200,
    navigationContentColor = AppTheme.colors.neutral200,
    yearContentColor = AppTheme.colors.neutral200,
    currentYearContentColor = AppTheme.colors.primary900,
    selectedYearContentColor = AppTheme.colors.white,
    selectedYearContainerColor = AppTheme.colors.primary900,
    dayContentColor = AppTheme.colors.neutral200,
    selectedDayContentColor = AppTheme.colors.white,
    selectedDayContainerColor = AppTheme.colors.primary900,
    todayContentColor = AppTheme.colors.primary900,
    todayDateBorderColor = AppTheme.colors.primary900,
    dividerColor = AppTheme.colors.neutral30,
  )

  val datePickerState = rememberDatePickerState(
    initialSelectedDateMillis = data.datePickerDataVMS.getInitialSelectedDate(initialDate = data.initialDate),
    initialDisplayMode = DisplayMode.Picker,
    selectableDates = object : SelectableDates {
      override fun isSelectableDate(utcTimeMillis: Long): Boolean {
        return data.datePickerDataVMS.isDateSelectable(currentCalendarDate = utcTimeMillis)
      }
    },
  )

  DatePickerDialog(
    shape = AppTheme.shapes.radius200,
    colors = datePickerColors,
    onDismissRequest = data.close,
    confirmButton = {
      Box(
        modifier = Modifier
          .padding(end = customSpacing),
      ) {
        Button(
          data = ButtonData(
            buttonSize = ButtonSize.Small,
            buttonType = ButtonType.WithText(
              label = CommonUILabelProvider.okLabel(),
            ),
            buttonVariant = ButtonVariant.Tertiary,
            onClick = {
              datePickerState.selectedDateMillis?.let {
                data.onDateChange(Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate())
              }
              data.close()
            },
          ),
        )
      }
    },
    dismissButton = {
      Button(
        data = ButtonData(
          buttonSize = ButtonSize.Small,
          buttonType = ButtonType.WithText(
            label = CommonUILabelProvider.cancelLabel(),
          ),
          buttonVariant = ButtonVariant.Tertiary,
          onClick = data.close,
        ),
      )
    },
  ) {
    DatePicker(
      state = datePickerState,
      colors = datePickerColors,
      title = {
        CustomText(
          label = CommonUILabelProvider.selectDateLabel(),
          style = AppTheme.typography.bodySmallMedium,
          color = AppTheme.colors.neutral200,
          modifier = Modifier.padding(
            start = AppTheme.dimensions.spacing300,
            end = AppTheme.dimensions.spacing150,
            top = AppTheme.dimensions.spacing250,
            bottom = AppTheme.dimensions.spacing200,
          ),
        )
      },
      headline = {
        DatePickerDefaults.DatePickerHeadline(
          selectedDateMillis = datePickerState.selectedDateMillis,
          displayMode = datePickerState.displayMode,
          dateFormatter = remember { DatePickerDefaults.dateFormatter() },
          modifier = Modifier.padding(
            start = AppTheme.dimensions.spacing300,
            end = AppTheme.dimensions.spacing150,
            top = AppTheme.dimensions.zero,
            bottom = AppTheme.dimensions.spacing100,
          ),
        )
      },
      showModeToggle = false,
    )
  }
}

@Preview
@Composable
fun DatePickerDialogComponentPreview() {
  DatePickerDialogComponent(
    data = DatePickerDialogData(
      initialDate = LocalDate.of(2024, 7, 16),
      onDateChange = {},
      close = {},
      datePickerDataVMS = DatePickerDataVMSImpl(
        minDate = LocalDate.of(2024, 7, 4),
        maxDate = LocalDate.of(2024, 7, 24),
      ),
    ),
  )
}
