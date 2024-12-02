package com.TechConnecGrupo3.TechConnecapi.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-01T13:51:22-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class ReportMapperImpl implements ReportMapper {

    @Override
    public ReportDTO toDTO(Report report) {
        if ( report == null ) {
            return null;
        }

        ReportDTO reportDTO = new ReportDTO();

        if ( report.getReportType() != null ) {
            reportDTO.setReportType( report.getReportType().name() );
        }
        reportDTO.setGeneratedBy( report.getGeneratedBy() );
        reportDTO.setGeneratedAt( report.getGeneratedAt() );
        reportDTO.setReportDetails( report.getReportDetails() );

        return reportDTO;
    }

    @Override
    public Report toEntity(ReportDTO reportDTO) {
        if ( reportDTO == null ) {
            return null;
        }

        Report report = new Report();

        if ( reportDTO.getReportType() != null ) {
            report.setReportType( Enum.valueOf( ReportType.class, reportDTO.getReportType() ) );
        }
        report.setGeneratedBy( reportDTO.getGeneratedBy() );
        report.setGeneratedAt( reportDTO.getGeneratedAt() );
        report.setReportDetails( reportDTO.getReportDetails() );

        return report;
    }
}
