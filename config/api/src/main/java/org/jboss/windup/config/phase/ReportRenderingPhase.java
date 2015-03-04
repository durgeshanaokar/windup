package org.jboss.windup.config.phase;

/**
 * Previous: {@link PostReportGenerationPhase}<br/>
 * Next: {@link PostReportRenderingPhase}
 * 
 * <p>
 * Reports will be rendered to the disk during this phase.
 * </p>
 * 
 * @author jsightler
 *
 */
public class ReportRenderingPhase extends RulePhase
{
    public ReportRenderingPhase()
    {
        super(ReportRenderingPhase.class);
    }

    @Override
    public Class<? extends RulePhase> getExecuteAfter()
    {
        return PostReportGenerationPhase.class;
    }

    @Override
    public Class<? extends RulePhase> getExecuteBefore()
    {
        return null;
    }
}
