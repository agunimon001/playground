Private Sub Workbook_SheetChange(ByVal Sh As Object, ByVal Target As Range)

For Each col In Target.EntireColumn.Columns
    col.AutoFit
    col.ColumnWidth = col.ColumnWidth + 1.5
Next

End Sub
