package com.dev.campusfrontute.models;

public class MdlCourse {
    private long id;
    private long category;
    private long sortorder;
    private String fullname;
    private String shortname;
    private String idnumber;
    private Integer plan;
    private String codcourse;
    private Integer section;
    private String naturaleza;
    private String horario;
    private String summary;
    private byte summaryformat;
    private String format;
    private byte showgrades;
    private int newsitems;
    private long startdate;
    private long enddate;
    private boolean relativedatesmode;
    private long marker;
    private long maxbytes;
    private short legacyfiles;
    private short showreports;
    private Boolean visible;
    private Boolean visibleold;
    private Boolean downloadcontent;
    private short groupmode;
    private short groupmodeforce;
    private long defaultgroupingid;
    private String lang;
    private String calendartype;
    private String theme;
    private long timecreated;
    private long timemodified;
    private boolean requested;
    private boolean enablecompletion;
    private boolean completionnotify;
    private long cacherev;
    private Long originalcourseid;
    private boolean showactivitydates;
    private Boolean showcompletionconditions;

    // Constructor's
    public MdlCourse(){}

    public MdlCourse(long id, long category, long sortorder, String fullname, String shortname, String idnumber, Integer plan, String codcourse, Integer section, String naturaleza, String horario, String summary, byte summaryformat, String format, byte showgrades, int newsitems, long startdate, long enddate, boolean relativedatesmode, long marker, long maxbytes, short legacyfiles, short showreports, Boolean visible, Boolean visibleold, Boolean downloadcontent, short groupmode, short groupmodeforce, long defaultgroupingid, String lang, String calendartype, String theme, long timecreated, long timemodified, boolean requested, boolean enablecompletion, boolean completionnotify, long cacherev, Long originalcourseid, boolean showactivitydates, Boolean showcompletionconditions) {
        this.id = id;
        this.category = category;
        this.sortorder = sortorder;
        this.fullname = fullname;
        this.shortname = shortname;
        this.idnumber = idnumber;
        this.plan = plan;
        this.codcourse = codcourse;
        this.section = section;
        this.naturaleza = naturaleza;
        this.horario = horario;
        this.summary = summary;
        this.summaryformat = summaryformat;
        this.format = format;
        this.showgrades = showgrades;
        this.newsitems = newsitems;
        this.startdate = startdate;
        this.enddate = enddate;
        this.relativedatesmode = relativedatesmode;
        this.marker = marker;
        this.maxbytes = maxbytes;
        this.legacyfiles = legacyfiles;
        this.showreports = showreports;
        this.visible = visible;
        this.visibleold = visibleold;
        this.downloadcontent = downloadcontent;
        this.groupmode = groupmode;
        this.groupmodeforce = groupmodeforce;
        this.defaultgroupingid = defaultgroupingid;
        this.lang = lang;
        this.calendartype = calendartype;
        this.theme = theme;
        this.timecreated = timecreated;
        this.timemodified = timemodified;
        this.requested = requested;
        this.enablecompletion = enablecompletion;
        this.completionnotify = completionnotify;
        this.cacherev = cacherev;
        this.originalcourseid = originalcourseid;
        this.showactivitydates = showactivitydates;
        this.showcompletionconditions = showcompletionconditions;
    }


    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public long getSortorder() {
        return sortorder;
    }

    public void setSortorder(long sortorder) {
        this.sortorder = sortorder;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public Integer getPlan() {
        return plan;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    public String getCodcourse() {
        return codcourse;
    }

    public void setCodcourse(String codcourse) {
        this.codcourse = codcourse;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public byte getSummaryformat() {
        return summaryformat;
    }

    public void setSummaryformat(byte summaryformat) {
        this.summaryformat = summaryformat;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public byte getShowgrades() {
        return showgrades;
    }

    public void setShowgrades(byte showgrades) {
        this.showgrades = showgrades;
    }

    public int getNewsitems() {
        return newsitems;
    }

    public void setNewsitems(int newsitems) {
        this.newsitems = newsitems;
    }

    public long getStartdate() {
        return startdate;
    }

    public void setStartdate(long startdate) {
        this.startdate = startdate;
    }

    public long getEnddate() {
        return enddate;
    }

    public void setEnddate(long enddate) {
        this.enddate = enddate;
    }

    public boolean isRelativedatesmode() {
        return relativedatesmode;
    }

    public void setRelativedatesmode(boolean relativedatesmode) {
        this.relativedatesmode = relativedatesmode;
    }

    public long getMarker() {
        return marker;
    }

    public void setMarker(long marker) {
        this.marker = marker;
    }

    public long getMaxbytes() {
        return maxbytes;
    }

    public void setMaxbytes(long maxbytes) {
        this.maxbytes = maxbytes;
    }

    public short getLegacyfiles() {
        return legacyfiles;
    }

    public void setLegacyfiles(short legacyfiles) {
        this.legacyfiles = legacyfiles;
    }

    public short getShowreports() {
        return showreports;
    }

    public void setShowreports(short showreports) {
        this.showreports = showreports;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getVisibleold() {
        return visibleold;
    }

    public void setVisibleold(Boolean visibleold) {
        this.visibleold = visibleold;
    }

    public Boolean getDownloadcontent() {
        return downloadcontent;
    }

    public void setDownloadcontent(Boolean downloadcontent) {
        this.downloadcontent = downloadcontent;
    }

    public short getGroupmode() {
        return groupmode;
    }

    public void setGroupmode(short groupmode) {
        this.groupmode = groupmode;
    }

    public short getGroupmodeforce() {
        return groupmodeforce;
    }

    public void setGroupmodeforce(short groupmodeforce) {
        this.groupmodeforce = groupmodeforce;
    }

    public long getDefaultgroupingid() {
        return defaultgroupingid;
    }

    public void setDefaultgroupingid(long defaultgroupingid) {
        this.defaultgroupingid = defaultgroupingid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCalendartype() {
        return calendartype;
    }

    public void setCalendartype(String calendartype) {
        this.calendartype = calendartype;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public long getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(long timecreated) {
        this.timecreated = timecreated;
    }

    public long getTimemodified() {
        return timemodified;
    }

    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }

    public boolean isRequested() {
        return requested;
    }

    public void setRequested(boolean requested) {
        this.requested = requested;
    }

    public boolean isEnablecompletion() {
        return enablecompletion;
    }

    public void setEnablecompletion(boolean enablecompletion) {
        this.enablecompletion = enablecompletion;
    }

    public boolean isCompletionnotify() {
        return completionnotify;
    }

    public void setCompletionnotify(boolean completionnotify) {
        this.completionnotify = completionnotify;
    }

    public long getCacherev() {
        return cacherev;
    }

    public void setCacherev(long cacherev) {
        this.cacherev = cacherev;
    }

    public Long getOriginalcourseid() {
        return originalcourseid;
    }

    public void setOriginalcourseid(Long originalcourseid) {
        this.originalcourseid = originalcourseid;
    }

    public boolean isShowactivitydates() {
        return showactivitydates;
    }

    public void setShowactivitydates(boolean showactivitydates) {
        this.showactivitydates = showactivitydates;
    }

    public Boolean getShowcompletionconditions() {
        return showcompletionconditions;
    }

    public void setShowcompletionconditions(Boolean showcompletionconditions) {
        this.showcompletionconditions = showcompletionconditions;
    }
}