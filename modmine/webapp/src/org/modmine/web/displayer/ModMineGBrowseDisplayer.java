package org.modmine.web.displayer;

/*
 * Copyright (C) 2002-2013 FlyMine
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  See the LICENSE file for more
 * information or http://www.gnu.org/copyleft/lesser.html.
 *
 */

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.intermine.api.InterMineAPI;
import org.intermine.web.displayer.ReportDisplayer;
import org.intermine.web.logic.config.ReportDisplayerConfig;
import org.intermine.web.logic.results.ReportObject;
import org.modmine.web.GBrowseParser.GBrowseTrack;
import org.modmine.web.MetadataCache;

/**
 * Displayer for GBrowse in modMine
 * @author Fengyuan Hu
 */
public class ModMineGBrowseDisplayer extends ReportDisplayer
{
    /**
     * Construct with config and the InterMineAPI.
     * @param config to describe the report displayer
     * @param im the InterMine API
     */
    public ModMineGBrowseDisplayer(ReportDisplayerConfig config, InterMineAPI im) {
        super(config, im);
    }

    @Override
    public void display(HttpServletRequest request, ReportObject reportObject) {

        // Ref - ExperimentController
        Map<String, List<GBrowseTrack>> subTracks = MetadataCache.getGBrowseTracks();
        request.setAttribute("subTracks", subTracks);

        request.setAttribute("object", reportObject.getObject());
    }
}
